package com.demowebshop.ui.business;

import com.demowebshop.ui.page.HomePage;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class HomePageBO {

    private final HomePage homePage;
    private final Page page;

    public HomePageBO(Page page) {
        this.page = page;
        this.homePage = new HomePage(page);
    }

    @Step("Open register page")
    public RegisterPageBO openRegisterPage() {
        homePage.clickRegisterButton();
        return new RegisterPageBO(page);
    }

    @Step("Open login page")
    public LoginPageBO openLoginPage() {
        homePage.clickLoginButton();
        return new LoginPageBO(page);
    }

    @Step("Logout")
    public HomePageBO clickLogout() {
        homePage.clickLogoutButton();
        return this;
    }

    @Step("Check visibility logout link")
    public boolean verifyUserLoggedIn() {
        return homePage.isLogoutVisible();
    }

    @Step("Search product: {productName}")
    public SearchPageBO searchProduct(String productName) {
        homePage.enterSearchText(productName);
        homePage.clickSearchButton();
        return new SearchPageBO(page);
    }
}
