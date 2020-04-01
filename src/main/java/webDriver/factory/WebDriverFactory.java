package webDriver.factory;

import config.Configuration;
import enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

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
            case IE:
                driver = createIEDriver();
                break;
            default:
                throw new RuntimeException("Unknown web driver type. Need to be added to webDriver.factory");
        }
        return driver;
    }

    protected WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        return new ChromeDriver();
    }

    protected WebDriver createFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        return new FirefoxDriver();
    }

    protected WebDriver createIEDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability("InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION", true);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability("ignoreZoomSetting", true);
        capabilities.setCapability("ignoreProtectedModeSettings", true);
        capabilities.setCapability("initialBrowserUrl", Configuration.url);
        System.setProperty("webdriver.ie.driver", "src\\main\\resources\\IEDriverServer.exe");
        return new InternetExplorerDriver(capabilities);
    }
}
