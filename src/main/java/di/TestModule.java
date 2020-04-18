package di;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import org.openqa.selenium.WebDriver;
import utils.WebDriverWaitUtils;
import webDriver.WebDriverManager;

public class TestModule extends AbstractModule {
    public TestModule() {
    }

    @Override
    protected void configure() {
        this.bind(WebDriverManager.class).in(Scopes.SINGLETON);
        this.bind(WebDriver.class).toProvider(WebDriverManager.class).in(Scopes.SINGLETON);
        this.bind(WebDriverWaitUtils.class).in(Scopes.SINGLETON);
    }
}
