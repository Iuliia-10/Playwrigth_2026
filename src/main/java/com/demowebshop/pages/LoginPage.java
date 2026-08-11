package com.demowebshop.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator errorMessage;

    public LoginPage(Page page) {
        super(page);
        this.emailInput = page.locator("#Email");
        this.passwordInput = page.locator("#Password");
        this.loginButton = page.locator(".login-button");
        this.errorMessage = page.locator(".validation-summary-errors");
    }

    public HomePage login(String email, String password) {
        emailInput.fill(email);
        passwordInput.fill(password);
        loginButton.click();
        return new HomePage(page);
    }

    public String getErrorMessage() {
        return errorMessage.textContent();
    }
}
