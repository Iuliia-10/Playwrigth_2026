package com.demowebshop.tests;

import com.demowebshop.ui.business.LoginPageBO;
import com.demowebshop.ui.business.RegisterPageBO;
import com.demowebshop.ui.page.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthTest extends BaseTest {

    @Test
    public void testSuccessfulRegistration() {
        RegisterPageBO registerPageBO = homePageBO.openRegisterPage();

        registerPageBO.registerRandomUser();

        Assert.assertTrue(registerPageBO.getSuccessMessage().contains("Your registration completed"));
    }

    @Test
    public void testSuccessfulLoginAndLogout() {
        RegisterPageBO registerPageBO = homePageBO.openRegisterPage();

        String email = registerPageBO.registerRandomUser();

        homePageBO.clickLogout();

        LoginPageBO loginPageBO = homePageBO.openLoginPage();
        homePageBO = loginPageBO.login(email, RegisterPage.DEFAULT_PASSWORD);

        Assert.assertTrue(homePageBO.verifyUserLoggedIn(), "Logout link should be visible after login");

        homePageBO.clickLogout();
        Assert.assertFalse(homePageBO.verifyUserLoggedIn(), "Logout link should disappear after logout");
    }
    @DataProvider
    private Object[][] invalidLoginData() {
        return new Object[][]{
                {"wrong_email@test.com", "Login was unsuccessful"},
                {"email@test.com", "Login was unsuccessful"},
                {"email@testcom", "Please enter a valid email address"},
                {"wrong_email@test.", "Please enter a valid email address"}
        };
    }

    @Test(dataProvider = "invalidLoginData")
    public void testInvalidLogin(String email, String expectedError) {
        LoginPageBO loginPageBO = homePageBO.openLoginPage();

        loginPageBO.login(email, "WrongPassword!");

        String actualErrorText = loginPageBO.getErrorMessage();

        Assert.assertTrue(actualErrorText.contains(expectedError),
                String.format("Ожидаемая ошибка '%s' не найдена. Фактический текст ошибки: '%s'",
                        expectedError, actualErrorText));
    }
}