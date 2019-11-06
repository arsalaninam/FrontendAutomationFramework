package com.abc.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {

    public static long PAGE_LOAD_TIMEOUT = 15;
    public static long IMPLICIT_WAIT = 10;

    /**********************************************
     * Explicit Wait for visibility of an element
     *
     * @param driver - WebDriver instance
     * @param element - Element to be Displayed
     **********************************************/

    public static void waitForVisibilityOfElement(WebDriver driver, WebElement element) {
        WebDriverWait explicitWait = new WebDriverWait(driver, PAGE_LOAD_TIMEOUT);
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    /*************************************************
     * Explicit Wait for visibility of an element and
     * enters text to the text box
     *
     * @param driver - WebDriver instance
     * @param element - Element to be Displayed
     * @param keys - Value to send in text box
     *************************************************/

    public static void sendKeysToTextBox(WebDriver driver, WebElement element, String keys) {
        waitForVisibilityOfElement(driver, element);
        element.sendKeys(keys);
    }
}
