import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class SoftServeTest {

    private final By btnSearch = By.xpath("//a[contains(@class, 'search')]");
    private final By inpSearchBox = By.xpath("//input[@type='text']");
    private final By searchResult = By.xpath("//div[@class='search-page__list']//h3");

    private final String url = "https://www.softserveinc.com/uk-ua";
    private final String query = "academy";
    private final String expectedResult = "IT Академія";

    private static WebDriver driver;

    @Test
    public void verifySerch() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
        driver.manage().window().maximize();
        driver.navigate().to(url);

        driver.findElement(btnSearch).click();
        webDriverWait.until(d -> driver.findElement(inpSearchBox).isDisplayed());
        driver.findElement(inpSearchBox).sendKeys(query);
        driver.findElement(inpSearchBox).sendKeys(Keys.ENTER);

        Assert.assertEquals(driver.findElements(searchResult).get(0).getText(), expectedResult);
        driver.quit();
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        if (!result.isSuccess()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File source = screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source, new File("Screenshots\\"
                        + result.getName() + "[" + LocalDate.now() + "][" + System.currentTimeMillis() + "].png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
