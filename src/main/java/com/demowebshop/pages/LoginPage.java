package com.demowebshop.pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    private final LazyWebElement emailInput = locateElement("#Email");
    private final LazyWebElement passwordInput = locateElement("#Password");
    private final LazyWebElement loginButton = locateElement(".login-button");
    private final LazyWebElement errorMessage = locateElement(".validation-summary-errors");

    public LoginPage(Page page) {
        super(page);
    }

    public HomePage login(String email, String password) {
        emailInput.fill(email);
        passwordInput.fill(password);
        loginButton.click();
        return new HomePage(page);
    }

    public String getErrorMessage() {
        return errorMessage.textContent().trim();
    }
}
