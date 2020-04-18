package ui;

import com.google.inject.Inject;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pageObject.SoftServePage;

import java.util.NoSuchElementException;

import static enums.SuiteGroups.SoftServeGroup;

@Epic("Smoke Tests")
@Feature("Search Tests")
public class SoftServeTest extends BaseUITest {
    @Inject
    private SoftServePage softServePage;

    @Test(description = "Test of SoftServe search",
            groups = {SoftServeGroup})
    @Description("Verify that query result is presence in search")
    @Issue("COM-1")
    @Severity(SeverityLevel.NORMAL)
    public void verifySearch() {
        softServePage.enterSearchQuery("academy");
        softServePage.verifyThatResultIsPresence("IT Академія");
    }

    @Test(description = "Test of SoftServe search",
            groups = {SoftServeGroup})
    @Description("Verify that query result is presence in search")
    @Issue("COM-2")
    @Severity(SeverityLevel.NORMAL)
    public void verifySearch2() {
        throw new NoSuchElementException("Element doesn't exist on the page");
    }

    @Test(description = "Test of SoftServe search",
            groups = {SoftServeGroup})
    @Description("Verify that query result is presence in search")
    @Issue("COM-3")
    @Severity(SeverityLevel.NORMAL)
    public void verifySearch3() {
        softServePage.enterSearchQuery("academy");
        softServePage.verifyThatResultIsPresence("IT Академія-2020");
    }

    @Test(description = "Test of SoftServe search",
            groups = {SoftServeGroup})
    @Description("Verify that query result is presence in search")
    @Issue("COM-4")
    @Severity(SeverityLevel.NORMAL)
    public void verifySearch4() {
        throw new NullPointerException("data not found");
    }
}
