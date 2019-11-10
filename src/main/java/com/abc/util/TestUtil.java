package com.abc.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.abc.constant.Constant.PAGE_LOAD_TIMEOUT;

public class TestUtil {

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

    /**********************************************
     * Explicit Wait for visibility of an element
     *
     * @param driver - WebDriver instance
     * @param element - Element to be Displayed
     * @param timeout - Explicit wait Timeout
     **********************************************/

    public static void waitForVisibilityOfElement(WebDriver driver, WebElement element, long timeout) {
        WebDriverWait explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }
}
