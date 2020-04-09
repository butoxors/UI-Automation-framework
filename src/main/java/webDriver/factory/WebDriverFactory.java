package webDriver.factory;

import enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static config.Configuration.webDriverName;

public class WebDriverFactory {
    public WebDriver createWebDriver(DriverType driverType) {
        WebDriver driver;
        switch (driverType) {
            case CHROME:
                driver = createChromeDriver();
                break;
            default:
                throw new RuntimeException("Unknown web driver type. Need to be added to webDriver.factory");
        }
        return driver;
    }

    protected WebDriver createChromeDriver() {
        String prefix = System.getProperty("os.name").contains("Win") ? ".exe" : "";
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\webdrivers\\" + webDriverName + prefix);
        return new ChromeDriver();
    }
}
