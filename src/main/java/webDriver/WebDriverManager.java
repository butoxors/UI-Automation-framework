package webDriver;

import com.google.inject.Provider;
import config.Configuration;
import enums.DriverType;
import org.openqa.selenium.WebDriver;
import webDriver.factory.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import static config.Configuration.implicitWaitTimeOut;

public abstract class WebDriverManager implements Provider<WebDriver> {

    private WebDriver driver;
    private static final DriverType DRIVER_TYPE = Configuration.driverType;

    public WebDriverManager() {
        this.createDriver();
        this.manageWebDriver();
    }

    public final WebDriver get() {
        return this.driver;
    }

    public final WebDriver createDriver() {
        WebDriverFactory factory = new WebDriverFactory();
        driver = factory.createWebDriver(DRIVER_TYPE);
        if (driver != null)
            WebDriverContainer.setWebDriver(driver);
        return driver;
    }

    public final void manageWebDriver() {
        driver.manage().timeouts().implicitlyWait(implicitWaitTimeOut, TimeUnit.SECONDS);
        driver.navigate().to(Configuration.url);
    }

    public final void tearDown(boolean closeBrowser) {
        if (closeBrowser) {
            driver.quit();
        }
        WebDriverContainer.removeWebDrivers();
    }
}
