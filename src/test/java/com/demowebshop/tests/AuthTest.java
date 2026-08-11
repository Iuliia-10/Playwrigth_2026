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
        LoginPage loginPage = homePage.clickLogin();

        // Предполагается зарегистрированный пользователь
        homePage = loginPage.login("testuser12345@test.com", "Password123!");

        Assert.assertTrue(homePage.isLogoutVisible(), "Logout link should be visible after login");

        homePage.clickLogout();
        Assert.assertFalse(homePage.isLogoutVisible(), "Logout link should disappear after logout");
    }

    @Test
    public void testInvalidLogin() {
        HomePage homePage = new HomePage(page);
        LoginPage loginPage = homePage.clickLogin();

        loginPage.login("wrong_email@test.com", "WrongPassword!");

        Assert.assertTrue(loginPage.getErrorMessage().contains("The credentials provided are incorrect"));
    }
}
