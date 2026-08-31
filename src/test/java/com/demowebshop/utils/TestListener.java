package com.demowebshop.utils;

import com.demowebshop.tests.ui.BaseTest;
import com.microsoft.playwright.Page;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.file.Paths;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();

        // Проверяем, относится ли упавший тест к UI-тестам (наследует ли он BaseTest)
        if (testClass instanceof BaseTest) {
            Page page = ((BaseTest) testClass).getPage();

            if (page != null) {
                String screenshotName = "build/screenshots/" + result.getName() + "_" + System.currentTimeMillis() + ".png";
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotName)).setFullPage(true));
                System.out.println("Screenshot saved to: " + screenshotName);
            }
        } else {
            // Для API-тестов просто выводим сообщение в консоль без снятия скриншота
            System.out.println("API Test failed: " + result.getName() + " | Reason: " + result.getThrowable().getMessage());
        }
    }
}