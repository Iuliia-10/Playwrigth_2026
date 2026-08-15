package com.demowebshop.tests;

import com.demowebshop.pages.HomePage;
import com.microsoft.playwright.Locator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void testSearchProduct() {
        HomePage homePage = new HomePage(page);
        homePage.searchProduct("Computer");

        Locator productTitles = page.locator(".product-title");
        Assert.assertTrue(productTitles.count() > 0, "Products should be displayed in search results");
    }
}
