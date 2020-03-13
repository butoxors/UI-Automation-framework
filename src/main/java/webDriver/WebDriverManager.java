package webDriver;

import enums.DriverType;
import org.openqa.selenium.WebDriver;
import webDriver.factory.WebDriverFactory;

public class WebDriverManager {
    private WebDriver driver;

    public WebDriver get() {
        return driver;
    }

    public WebDriver createDriver(DriverType driverType) {
        WebDriverFactory factory = new WebDriverFactory();
        driver = factory.createWebDriver(driverType);
        return driver;
    }

    public void manageWebDriver() {
        driver.manage().window().maximize();
    }

    public void tearDown(boolean closeBrowser) {
        if (closeBrowser) {
            driver.quit();
        }
    }
}
