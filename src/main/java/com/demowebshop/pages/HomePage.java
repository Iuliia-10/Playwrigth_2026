package com.demowebshop.pages;

import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    private final LazyWebElement registerLink = locateElement(".ico-register");
    private final LazyWebElement loginLink = locateElement(".ico-login");
    private final LazyWebElement logoutLink = locateElement(".ico-logout");
    private final LazyWebElement accountEmail = locateElement(".header-links .account");
    private final LazyWebElement searchInput = locateElement("#small-searchterms");
    private final LazyWebElement searchButton = locateElement("input.search-box-button");

    public HomePage(Page page) {
        super(page);
    }

    public RegisterPage clickRegister() {
        registerLink.click();
        return new RegisterPage(page);
    }

    public LoginPage clickLogin() {
        loginLink.click();
        return new LoginPage(page);
    }

    public void clickLogout() {
        logoutLink.click();
    }

    public boolean isLogoutVisible() {
        return logoutLink.isVisible();
    }

//    public String getLoggedInEmail() {
//        return accountEmail.textContent();
//    }

    public void searchProduct(String productName) {
        searchInput.fill(productName);
        searchButton.click();
    }
}
