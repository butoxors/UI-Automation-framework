package webDriver.factory;

import enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        String prefix = System.getProperty("os.name").equalsIgnoreCase("Linux") ? "" : ".exe";
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/" + webDriverName + prefix);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        return new ChromeDriver(options);
    }
}
