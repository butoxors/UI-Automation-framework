package ui;

import allure.TestNGCustomListener;
import com.google.inject.Inject;
import di.Graph;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import webDriver.WebDriverManager;

@Listeners({TestNGCustomListener.class})
public abstract class BaseUITest {

    @Inject
    private WebDriverManager webDriverManager;

    public void setUp() {
        injectMembers();
    }

    private void injectMembers() {
        Graph.createInjector().injectMembers(this);
    }

    @AfterMethod
    public void tearDown() {
        webDriverManager.tearDown(true);
    }
}
