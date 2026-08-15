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
        HomePage homePage = new HomePage(page);
        RegisterPage registerPage = homePage.clickRegister();

        // Использование нового метода для быстрой регистрации с генерацией email
        registerPage.registerRandomUser("Password123!");

        Assert.assertTrue(registerPage.getSuccessMessage().contains("Your registration completed"));
    }

    @Test
    public void testSuccessfulLoginAndLogout() {
        HomePage homePage = new HomePage(page);
        String password = "Password123!";

        // Переходим на страницу регистрации и вызываем новый метод
        RegisterPage registerPage = homePage.clickRegister();
        String email = registerPage.registerRandomUser(password);

        // Разлогиниваемся после регистрации
        homePage.clickLogout();

        // Выполняем вход новым пользователем
        LoginPage loginPage = homePage.clickLogin();
        homePage = loginPage.login(email, password);

        // Проверки
        Assert.assertTrue(homePage.isLogoutVisible(), "Logout link should be visible after login");

        homePage.clickLogout();
        Assert.assertFalse(homePage.isLogoutVisible(), "Logout link should disappear after logout");
    }

    @Test(dataProvider = "invalidLoginData")
    public void testInvalidLogin(String email, String expectedError) {
        HomePage homePage = new HomePage(page);
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
                // Сценарий 1: Несуществующий аккаунт -> общая ошибка входа
                {"wrong_email@test.com", "Login was unsuccessful"},

                // Сценарий 2: Удаленный/заблокированный аккаунт -> общая ошибка входа
                {"email@test.com", "Login was unsuccessful"},

                // Сценарий 3: Некорректный домен -> ошибка валидации формата email
                {"email@testcom", "Please enter a valid email address"},

                // Сценарий 4: Незавершенный адрес -> ошибка валидации формата email
                {"wrong_email@test.", "Please enter a valid email address"}
        };
    }
}
