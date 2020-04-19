package pageObject;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverWaitUtils;

import java.util.List;

public abstract class BasePage {

    @Inject
    private WebDriver webDriver;

    public BasePage() {
        PageFactory.initElements(webDriver, this);
    }

    protected WebElement findElementByXPath(String xPath) {
        return webDriver.findElement(By.xpath(xPath));
    }

    protected List<WebElement> findElementsByXPath(String xPath) {
        return webDriver.findElements(By.xpath(xPath));
    }

    protected void waitForPageToLoad() {
        WebDriverWaitUtils.waitForPageToLoad();
    }
}
