package com.demowebshop.tests;

import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest extends BaseTest {

    @Test
    public void testSuccessfulRegistration() {
        HomePage homePage = new HomePage(page);
        RegisterPage registerPage = homePage.clickRegister();

        String uniqueEmail = "user" + System.currentTimeMillis() + "@test.com";
        registerPage.registerUser("John", "Doe", uniqueEmail, "Password123!");

        Assert.assertTrue(registerPage.getSuccessMessage().contains("Your registration completed"));
    }

    @Test
    public void testSuccessfulLoginAndLogout() {
        HomePage homePage = new HomePage(page);

        String email = "user" + System.currentTimeMillis() + "@test.com";
        String password = "Password123!";

        RegisterPage registerPage = homePage.clickRegister();
        registerPage.registerUser("John", "Doe", email, password);

        homePage.clickLogout();

        LoginPage loginPage = homePage.clickLogin();
        homePage = loginPage.login(email, password);

        Assert.assertTrue(homePage.isLogoutVisible(), "Logout link should be visible after login");

        homePage.clickLogout();
        Assert.assertFalse(homePage.isLogoutVisible(), "Logout link should disappear after logout");
    }

    @Test
    public void testInvalidLogin() {
        HomePage homePage = new HomePage(page);
        LoginPage loginPage = homePage.clickLogin();

        loginPage.login("wrong_email@test.com", "WrongPassword!");

        String actualErrorMessage = loginPage.getErrorMessage();

        Assert.assertTrue(actualErrorMessage.contains("Login was unsuccessful. Please correct the errors and try again."),
                "Wrong message: '" + actualErrorMessage + "'");

        Assert.assertTrue(actualErrorMessage.contains("No customer account found"),
                "Wrong message:: '" + actualErrorMessage + "'");
    }
}
