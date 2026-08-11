package com.demowebshop.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class RegisterPage extends BasePage {
    private final Locator genderRadio;
    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator confirmPasswordInput;
    private final Locator registerButton;
    private final Locator resultMessage;

    public RegisterPage(Page page) {
        super(page);
        this.genderRadio = page.locator("#gender-male");
        this.firstNameInput = page.locator("#FirstName");
        this.lastNameInput = page.locator("#LastName");
        this.emailInput = page.locator("#Email");
        this.passwordInput = page.locator("#Password");
        this.confirmPasswordInput = page.locator("#ConfirmPassword");
        this.registerButton = page.locator("#register-button");
        this.resultMessage = page.locator(".result");
    }

    public void registerUser(String firstName, String lastName, String email, String password) {
        genderRadio.check();
        firstNameInput.fill(firstName);
        lastNameInput.fill(lastName);
        emailInput.fill(email);
        passwordInput.fill(password);
        confirmPasswordInput.fill(password);
        registerButton.click();
    }

    public String getSuccessMessage() {
        return resultMessage.textContent();
    }
}
