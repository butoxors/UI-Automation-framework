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
        String prefix = System.getProperty("os.name").contains("Win") ? ".exe" : "";
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\webdrivers\\" + webDriverName + prefix);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors", "--no-sandbox");
        return new ChromeDriver();
    }
}
