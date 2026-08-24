package com.demowebshop.ui.business;

import com.demowebshop.ui.page.LoginPage;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class LoginPageBO {

    private final LoginPage loginPage;
    private final Page page;

    public LoginPageBO(Page page) {
        this.page = page;
        this.loginPage = new LoginPage(page);
    }

    @Step("Perform login with email: {email}")
    public HomePageBO login(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        return new HomePageBO(page);
    }

    @Step("Get login error message")
    public String getErrorMessage() {
        String summaryError = loginPage.isSummaryErrorVisible() ? loginPage.getSummaryErrorText() : "";
        String fieldError = loginPage.isEmailFieldErrorVisible() ? loginPage.getEmailFieldErrorText() : "";
        return (summaryError + " " + fieldError).trim();
    }
}
