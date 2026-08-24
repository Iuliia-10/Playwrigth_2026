package com.demowebshop.ui.page;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class RegisterPage extends BasePage {

    public static final String DEFAULT_PASSWORD = "Password123!";

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

    @Step("Select gender radiobutton")
    public void selectGenderMale() {
        genderRadio.check();
    }

    @Step("Enter first name")
    public void enterFirstName(String firstName) {
        firstNameInput.fill(firstName);
    }

    @Step("Enter last name")
    public void enterLastName(String lastName) {
        lastNameInput.fill(lastName);
    }

    @Step("Enter email")
    public void enterEmail(String email) {
        emailInput.fill(email);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        passwordInput.fill(password);
    }

    @Step("Enter confirm password")
    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordInput.fill(confirmPassword);
    }

    @Step("Click register button")
    public void clickRegisterButton() {
        registerButton.click();
    }

    @Step("Get result text message")
    public String getResultMessageText() {
        return resultMessage.textContent();
    }
}
