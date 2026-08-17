package com.demowebshop.tests;

import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.SearchPage;
import com.microsoft.playwright.Locator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    public void testSearchProduct() {
        LOGGER.info("Search product, logger");
        HomePage homePage = new HomePage(page);
       SearchPage searchPage = homePage.searchProduct("Computer");


        int productCount = searchPage.getProductTitleCount();
        Assert.assertTrue(productCount > 0, "Products should be displayed in search results. Found: " + productCount);
    }
}
