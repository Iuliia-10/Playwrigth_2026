package com.demowebshop.tests;

import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthTest extends BaseTest {


    @Test
    public void testSuccessfulRegistration() {
        RegisterPage registerPage = homePage.clickRegister();

        registerPage.registerRandomUser();

        Assert.assertTrue(registerPage.getSuccessMessage().contains("Your registration completed"));
    }

    @Test
    public void testSuccessfulLoginAndLogout() {
        RegisterPage registerPage = homePage.clickRegister();

        String email = registerPage.registerRandomUser();

        homePage.clickLogout();

        LoginPage loginPage = homePage.clickLogin();
        homePage = loginPage.login(email, RegisterPage.DEFAULT_PASSWORD);

        Assert.assertTrue(homePage.isLogoutVisible(), "Logout link should be visible after login");

        homePage.clickLogout();
        Assert.assertFalse(homePage.isLogoutVisible(), "Logout link should disappear after logout");
    }

    @Test(dataProvider = "invalidLoginData")
    public void testInvalidLogin(String email, String expectedError) {
        LoginPage loginPage = homePage.clickLogin();

        loginPage.login(email, "WrongPassword!");

        // Собираем текст из обоих возможных мест возникновения ошибок
        String actualSummaryError = loginPage.getSummaryErrorMessage();
        String actualFieldError = loginPage.getEmailFieldError();
        String fullErrorText = actualSummaryError + " " + actualFieldError;

        // Проверяем, что хотя бы в одном из мест содержится ожидаемый текст ошибки
        Assert.assertTrue(fullErrorText.contains(expectedError),
                String.format("Ожидаемая ошибка '%s' не найдена. Фактический текст сводной ошибки: '%s', ошибки поля: '%s'",
                        expectedError, actualSummaryError, actualFieldError));
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
}
