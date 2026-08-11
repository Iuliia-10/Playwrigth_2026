package com.demowebshop.tests;

import com.demowebshop.config.ConfigReader;
import com.demowebshop.utils.TestListener;
import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();
        boolean isHeadless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));

        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless));
        context = browser.newContext();
        page = context.newPage();

        page.navigate(ConfigReader.getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    public Page getPage() {
        return page;
    }
}
