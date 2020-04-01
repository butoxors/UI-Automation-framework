import com.google.inject.Inject;
import di.Graph;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.ScreenshotUtils;
import webDriver.WebDriverManager;

import java.time.LocalDate;

public class BaseUITest {
    @Inject
    private WebDriverManager webDriverManager;

    public void setUp() {
        injectMembers();
    }

    private void injectMembers() {
        Graph.createInjector().injectMembers(this);
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
