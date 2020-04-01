package utils;

import config.Configuration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.WebDriverContainer;

public final class WebDriverWaitUtils {

    public static void waitAndClick(long timeOutInSeconds, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(WebDriverContainer.getWebDriver(), timeOutInSeconds);
        webDriverWait.until(d -> ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void waitAndClick(WebElement element) {
        waitAndClick(Configuration.explicitWaitTimeOut, element);
    }

    public static void waitAndSendText(long timeOutInSeconds, WebElement element, String text) {
        waitAndClick(timeOutInSeconds, element);
        element.clear();
        element.sendKeys(text);
    }

    public static void waitAndSendText(WebElement element, String text) {
        waitAndSendText(Configuration.explicitWaitTimeOut, element, text);
    }

    public static void waitForPageToLoad() {
        WebDriverWait webDriverWait = new WebDriverWait(WebDriverContainer.getWebDriver(), Configuration.ajaxWaitTimeOut);
        webDriverWait.until(d -> waitForDocumentReady());
        webDriverWait.until(d -> waitForAjaxRequestsComplete());
    }

    private static boolean waitForDocumentReady() {
        return getJSExecutor().executeScript("return document.readyState == 'complete'", new Object[0]).equals(true);
    }

    private static boolean waitForAjaxRequestsComplete() {
        return getJSExecutor().executeScript("return typeof(jQuery) == 'function' ? (jQuery.active == 0) : true", new Object[0]).equals(true);
    }

    private static JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) WebDriverContainer.getWebDriver();
    }
}
