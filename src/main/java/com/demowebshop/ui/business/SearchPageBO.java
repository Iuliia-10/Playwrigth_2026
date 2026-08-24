package com.demowebshop.ui.business;

import com.demowebshop.ui.page.SearchPage;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class SearchPageBO {

    private final SearchPage searchPage;
    private final Page page;

    public SearchPageBO(Page page) {
        this.page = page;
        this.searchPage = new SearchPage(page);
    }

    @Step("Verify search results count")
    public int getFoundProductsCount() {
        return searchPage.getProductTitleCount();
    }
}
