package com.demowebshop.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {
    private final Locator registerLink;
    private final Locator loginLink;
    private final Locator logoutLink;
    private final Locator accountEmail;
    private final Locator searchInput;
    private final Locator searchButton;

    public HomePage(Page page) {
        super(page);
        this.registerLink = page.locator(".ico-register");
        this.loginLink = page.locator(".ico-login");
        this.logoutLink = page.locator(".ico-logout");
        this.accountEmail = page.locator(".header-links .account");
        this.searchInput = page.locator("#small-searchterms");
        this.searchButton = page.locator("input[value='Search']");
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

    public String getLoggedInEmail() {
        return accountEmail.textContent();
    }

    public void searchProduct(String productName) {
        searchInput.fill(productName);
        searchButton.click();
    }
}
