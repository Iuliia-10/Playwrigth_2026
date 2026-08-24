package com.demowebshop.ui.business;

import com.demowebshop.ui.page.RegisterPage;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class RegisterPageBO {

    private final RegisterPage registerPage;
    private final Page page;

    public RegisterPageBO(Page page) {
        this.page = page;
        this.registerPage = new RegisterPage(page);
    }

    @Step("Fill registration form for user: {email}")
    public RegisterPageBO registerUser(String firstName, String lastName, String email, String password) {
        registerPage.selectGenderMale();
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.clickRegisterButton();
        return this;
    }

    @Step("Register random user")
    public String registerRandomUser() {
        String uniqueEmail = "user" + System.currentTimeMillis() + "@test.com";
        registerUser("John", "Doe", uniqueEmail, RegisterPage.DEFAULT_PASSWORD);
        return uniqueEmail;
    }

    @Step("Get registration success message")
    public String getSuccessMessage() {
        return registerPage.getResultMessageText();
    }
}
