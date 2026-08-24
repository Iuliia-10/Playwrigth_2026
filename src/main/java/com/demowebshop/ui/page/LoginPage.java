package com.demowebshop.ui.page;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class LoginPage extends BasePage {

    private final LazyWebElement emailInput = locateElement("#Email");
    private final LazyWebElement passwordInput = locateElement("#Password");
    private final LazyWebElement loginButton = locateElement(".login-button");
    private final LazyWebElement summaryErrorMessage = locateElement(".validation-summary-errors");
    private final LazyWebElement emailFieldError = locateElement("span[data-valmsg-for='Email']");

    public LoginPage(Page page) {
        super(page);
    }

    @Step("Enter Email")
    public void enterEmail(String email) {
        emailInput.fill(email);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        passwordInput.fill(password);
    }

    @Step("Click login button")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Check visibility of summary errors")
    public boolean isSummaryErrorVisible() {
        return summaryErrorMessage.isVisible();
    }

    @Step("GET summary errors")
    public String getSummaryErrorText() {
        return summaryErrorMessage.textContent().trim();
    }

    @Step("Check visibility of email field errors")
    public boolean isEmailFieldErrorVisible() {
        return emailFieldError.isVisible();
    }

    @Step("Get email field errors")
    public String getEmailFieldErrorText() {
        return emailFieldError.textContent().trim();
    }
}