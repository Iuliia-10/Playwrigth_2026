package com.demowebshop.pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    private final LazyWebElement emailInput = locateElement("#Email");
    private final LazyWebElement passwordInput = locateElement("#Password");
    private final LazyWebElement loginButton = locateElement(".login-button");
    private final LazyWebElement summaryErrorMessage = locateElement(".validation-summary-errors");
    private final LazyWebElement emailFieldError = locateElement("span[data-valmsg-for='Email']");

    public LoginPage(Page page) {
        super(page);
    }

    public HomePage login(String email, String password) {
        emailInput.fill(email);
        passwordInput.fill(password);
        loginButton.click();
        return new HomePage(page);
    }

    // Возвращает текст сводной ошибки над формой
    public String getSummaryErrorMessage() {
        return summaryErrorMessage.isVisible() ? summaryErrorMessage.textContent().trim() : "";
    }

    // Возвращает текст ошибки формата прямо под полем Email
    public String getEmailFieldError() {
        return emailFieldError.isVisible() ? emailFieldError.textContent().trim() : "";
    }
}