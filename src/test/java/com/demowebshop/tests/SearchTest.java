package com.demowebshop.tests;

import com.demowebshop.ui.business.SearchPageBO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    public void testSearchProduct() {
        LOGGER.info("Search product, logger");

        SearchPageBO searchPageBO = homePageBO.searchProduct("Computer");

        int productCount = searchPageBO.getFoundProductsCount();
        Assert.assertTrue(productCount > 0, "Products should be displayed in search results. Found: " + productCount);
    }
}