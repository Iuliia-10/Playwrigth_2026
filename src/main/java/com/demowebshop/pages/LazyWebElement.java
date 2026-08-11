package com.demowebshop.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.function.Supplier;

public class LazyWebElement {
    private final Supplier<Page> pageSupplier;
    private final String selector;

    public LazyWebElement(Supplier<Page> pageSupplier, String selector) {
        this.pageSupplier = pageSupplier;
        this.selector = selector;
    }

    private Locator getLocator() {
        return pageSupplier.get().locator(selector);
    }

    public void click() {
        getLocator().click();
    }

    public void fill(String text) {
        getLocator().fill(text);
    }

    public boolean isVisible() {
        return getLocator().isVisible();
    }

    public String textContent() {
        return getLocator().textContent();
    }

    public void check() {
        getLocator().check();
    }
}
