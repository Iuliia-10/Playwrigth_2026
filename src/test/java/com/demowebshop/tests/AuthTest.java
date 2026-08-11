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

        // 1. Создаем уникальный email для каждого прогона
        String email = "user" + System.currentTimeMillis() + "@test.com";
        String password = "Password123!";

        // 2. Регистрируем пользователя
        RegisterPage registerPage = homePage.clickRegister();
        registerPage.registerUser("John", "Doe", email, password);

        // 3. Выходим после регистрации, чтобы проверить чистый логин
        homePage.clickLogout();

        // 4. Выполняем логин созданным пользователем
        LoginPage loginPage = homePage.clickLogin();
        homePage = loginPage.login(email, password);

        // 5. Проверяем, что кнопка Logout появилась
        Assert.assertTrue(homePage.isLogoutVisible(), "Logout link should be visible after login");

        // 6. Выполняем logout и проверяем, что кнопка исчезла
        homePage.clickLogout();
        Assert.assertFalse(homePage.isLogoutVisible(), "Logout link should disappear after logout");
    }

    @Test
    public void testInvalidLogin() {
        HomePage homePage = new HomePage(page);
        LoginPage loginPage = homePage.clickLogin();

        loginPage.login("wrong_email@test.com", "WrongPassword!");

        String actualErrorMessage = loginPage.getErrorMessage();

        // Проверяем ключевые слова или фразу об ошибке входа
        boolean isErrorDisplayed = actualErrorMessage.contains("Login was unsuccessful")
                || actualErrorMessage.contains("The credentials provided are incorrect");

        Assert.assertTrue(isErrorDisplayed,
                "Текст ошибки входа не совпал. Фактический текст был: '" + actualErrorMessage + "'");
    }
}
