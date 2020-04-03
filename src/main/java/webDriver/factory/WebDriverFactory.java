package webDriver.factory;

import enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public WebDriver createWebDriver(DriverType driverType) {
        WebDriver driver;
        switch (driverType) {
            case CHROME:
                driver = createChromeDriver();
                break;
            case FIREFOX:
                driver = createFirefoxDriver();
                break;
            default:
                throw new RuntimeException("Unknown web driver type. Need to be added to webDriver.factory");
        }
        return driver;
    }

    protected WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\webDrivers\\chromedriver.exe");
        return new ChromeDriver();
    }

    protected WebDriver createFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\webDrivers\\geckodriver.exe");
        return new FirefoxDriver();
    }
}
