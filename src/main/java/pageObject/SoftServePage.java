package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;
import static utils.WebDriverWaitUtils.waitAndSendText;

public class SoftServePage extends BasePage {
    private final String btnSearch = "//a[contains(@class, 'search')]";
    private final String inpSearchBox = "//input[@type='text']";
    private final String lblSearchResults = "//div[@class='search-page__list']//h3";

    @Step("Enter query {query} to search input")
    public void enterSearchQuery(String query) {
        waitForPageToLoad();
        findElementByXPath(btnSearch).click();
        waitForPageToLoad();
        WebElement searchBox = findElementByXPath(inpSearchBox);
        waitAndSendText(searchBox, query);
        searchBox.sendKeys(Keys.ENTER);
    }

    @Step("Verify that {expectedResult} is presence in search results")
    public void verifyThatResultIsPresence(String expectedResult) {
        waitForPageToLoad();
        boolean isPresence = findElementsByXPath(lblSearchResults).stream()
                .anyMatch(x -> x.getText().equalsIgnoreCase(expectedResult));
        assertTrue(isPresence);
    }
}
