package webDriver;

import org.openqa.selenium.WebDriver;

public class WebDriverContainer {

    private static final ThreadLocal<WebDriver> threadLocalScope = new ThreadLocal();

    public WebDriverContainer() {
    }

    public static final WebDriver getWebDriver() {
        return (WebDriver) threadLocalScope.get();
    }

    public static final void setWebDriver(WebDriver driver) {
        threadLocalScope.set(driver);
    }

    public static final void removeWebDrivers() {
        threadLocalScope.remove();
    }
}
