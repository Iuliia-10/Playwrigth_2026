package com.demowebshop.ui.page;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

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

    @Step("Click register button")
    public void clickRegisterButton() {
        registerLink.click();
    }

    @Step("Click login button")
    public void clickLoginButton() {
        loginLink.click();
    }

    @Step("Click logout button")
    public void clickLogoutButton() {
        logoutLink.click();
    }

    @Step("Check the visibility of logout button")
    public boolean isLogoutVisible() {
        return logoutLink.isVisible();
    }

    @Step("Enter search text")
    public void enterSearchText(String text) {
        searchInput.fill(text);
    }

    @Step("Click search button")
    public void clickSearchButton() {
        searchButton.click();
    }
}
