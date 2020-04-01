package pageObject;

import com.google.inject.Inject;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static utils.WebDriverWaitUtils.waitAndSendText;

public class SoftServePage extends BasePage {
    @Inject
    private WebDriver driver;

    private final String btnSearch = "//a[contains(@class, 'search')]";
    private final String inpSearchBox = "//input[@type='text']";
    private final String lblSearchResults = "//div[@class='search-page__list']//h3";

    public void enterSearchQuery(String query) {
        findByXPath(btnSearch).click();
        var searchBox = findByXPath(inpSearchBox);
        waitAndSendText(searchBox, query);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void verifyThatResultIsPresence(String expectedResult) {
        boolean isPresence = driver.findElements(By.xpath(lblSearchResults)).stream()
                .anyMatch(x -> x.getText().equalsIgnoreCase(expectedResult));
        Assertions.assertThat(isPresence).isTrue();
    }
}
