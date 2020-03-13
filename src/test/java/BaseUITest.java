import config.Configuration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.ScreenshotUtils;
import webDriver.WebDriverManager;

import java.time.LocalDate;

public class BaseUITest {
    protected WebDriverManager webDriverManager;

    @BeforeTest
    public void setUp() {
        webDriverManager = new WebDriverManager();
        webDriverManager.createDriver(Configuration.driverType);
        webDriverManager.manageWebDriver();
        webDriverManager.get().navigate().to(Configuration.url);
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        if (!result.isSuccess()) {
            ScreenshotUtils.takeScreenshot(webDriverManager.get(),
                    result.getName() + "[" + LocalDate.now() + "][" + System.currentTimeMillis() + "].png");
        }
    }

    @AfterTest
    public void tearDown() {
        webDriverManager.tearDown(true);
    }
}
