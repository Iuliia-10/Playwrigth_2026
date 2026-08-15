package com.demowebshop.pages;

import com.microsoft.playwright.Page;

public class SearchPage extends BasePage {

    private final LazyWebElement productTitles = locateElement(".product-title");

    public SearchPage(Page page) {
        super(page);
    }

    public int getProductTitleCount() {
        return productTitles.count();
    }
}
