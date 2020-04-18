package di;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import org.openqa.selenium.WebDriver;
import utils.WebDriverWaitUtils;
import webDriver.WebDriverManager;

public class TestModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(WebDriverManager.class).in(Scopes.SINGLETON);
        bind(WebDriver.class).toProvider(WebDriverManager.class).in(Scopes.SINGLETON);
        bind(WebDriverWaitUtils.class).in(Scopes.SINGLETON);
    }
}
