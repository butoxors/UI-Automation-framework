package pageObject;

import com.google.inject.Inject;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverWaitUtils;
import webDriver.WebDriverManager;

public class BasePage {
    @Inject
    private WebDriver driver;

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected WebElement findByXPath(String xPath) {
        return driver.findElement(By.xpath(xPath));
    }

    protected void waitForPageToLoad() {
        WebDriverWaitUtils.waitForPageToLoad();
    }
}
