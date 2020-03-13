package pageObject;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class GooglePage extends BasePage {
    @FindBy(name = "q")
    public WebElement inpSearch;

    @FindBy(xpath = "//h3[contains(@class, 'LC20lb')]")
    public List<WebElement> lblTitle;

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void enterSearchQuery(String query) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inpSearch));
        inpSearch.sendKeys(query);
        inpSearch.sendKeys(Keys.ENTER);
    }

    public void verifyThatResultHasWord(String word) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(lblTitle));
        boolean count = lblTitle.stream().anyMatch(x -> x.getText().contains(word));
        Assertions.assertThat(count).isTrue();
    }
}
