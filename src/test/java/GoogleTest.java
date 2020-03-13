import org.testng.annotations.Test;
import pageObject.GooglePage;

public class GoogleTest extends BaseUITest {
    private GooglePage googlePage;

    @Test
    public void searchTest() {
        googlePage = new GooglePage(webDriverManager.get());
        String query = "Khai";
        String expectedTitle = "ХАІ: Головна";

        googlePage.enterSearchQuery(query);
        googlePage.verifyThatResultHasWord(expectedTitle);
    }
}
