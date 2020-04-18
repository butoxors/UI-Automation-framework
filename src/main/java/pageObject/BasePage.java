package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverWaitUtils;
import webDriver.WebDriverContainer;

import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BasePage() {
        PageFactory.initElements(WebDriverContainer.getWebDriver(), this);
    }

    protected WebElement findElementByXPath(String xPath) {
        return driver.findElement(By.xpath(xPath));
    }

    protected List<WebElement> findElementsByXPath(String xPath) {
        return driver.findElements(By.xpath(xPath));
    }

    protected void waitForPageToLoad() {
        WebDriverWaitUtils.waitForPageToLoad();
    }
}
