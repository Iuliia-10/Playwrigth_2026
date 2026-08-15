package com.demowebshop.tests;

import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.SearchPage;
import com.microsoft.playwright.Locator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void testSearchProduct() {
        HomePage homePage = new HomePage(page);
       SearchPage searchPage = homePage.searchProduct("Computer");

        int productCount = searchPage.getProductTitleCount();
        Assert.assertTrue(productCount > 0, "Products should be displayed in search results. Found: " + productCount);
    }
}
