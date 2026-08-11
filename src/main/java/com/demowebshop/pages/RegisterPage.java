package com.demowebshop.pages;

import com.microsoft.playwright.Page;

public class RegisterPage extends BasePage {

    private final LazyWebElement genderRadio = locateElement("#gender-male");
    private final LazyWebElement firstNameInput = locateElement("#FirstName");
    private final LazyWebElement lastNameInput = locateElement("#LastName");
    private final LazyWebElement emailInput = locateElement("#Email");
    private final LazyWebElement passwordInput = locateElement("#Password");
    private final LazyWebElement confirmPasswordInput = locateElement("#ConfirmPassword");
    private final LazyWebElement registerButton = locateElement("#register-button");
    private final LazyWebElement resultMessage = locateElement(".result");

    public RegisterPage(Page page) {
        super(page);
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
