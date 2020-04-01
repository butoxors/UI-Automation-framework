import com.google.inject.Inject;
import org.testng.annotations.Test;
import pageObject.SoftServePage;

public class SoftServeTest extends BaseUITest {

    @Inject
    private SoftServePage softServePage;

    @Test(description = "Test of SoftServe search")
    public void verifySerch() {
        setUp();
        softServePage.enterSearchQuery("academy");
        softServePage.verifyThatResultIsPresence("IT Академія");
    }
}
