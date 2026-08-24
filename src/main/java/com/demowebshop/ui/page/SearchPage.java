package com.demowebshop.ui.page;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class SearchPage extends BasePage {

    private final LazyWebElement productTitles = locateElement(".product-title");

    public SearchPage(Page page) {
        super(page);
    }

    @Step("Get product titles count")
    public int getProductTitleCount() {
        return productTitles.count();
    }
}
