package com.demowebshop.pages;

import com.microsoft.playwright.Page;

public abstract class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    protected LazyWebElement locateElement(String selector) {
        return new LazyWebElement(() -> this.page, selector);
    }
}