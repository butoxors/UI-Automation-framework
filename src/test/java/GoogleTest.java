import enums.DriverType;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import webDriver.factory.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class GoogleTest {
    private WebDriver driver;

    private final By inpSearch = By.name("q");
    private final By lblTitle = By.xpath("//h3[contains(@class, 'LC20lb')]");

    @Test
    public void searchTest() throws InterruptedException {
        String query = "Khai";
        String expectedTitle = "ХАІ: Головна";

        WebDriverFactory factory = new WebDriverFactory(); // Создание фабрики драйверов
        driver = factory.createWebDriver(DriverType.CHROME); // Создать драйвер с типом Chrome

        driver.manage().window().maximize(); // Установить окно бразуера на полный размер окна
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // Установить ожидание

        driver.navigate().to("https://google.com"); // Перейти на страницу https://google.com

        driver.findElement(inpSearch).sendKeys(query); // Вписать запрос
        driver.findElement(inpSearch).sendKeys(Keys.ENTER); // Нажать кнопку Enter
        // Проверить, что есть хотя бы 1 поисковой результат с искомым названием
        //boolean count = driver.findElements(lblTitle).stream().anyMatch(x -> x.getText().contains(expectedTitle));
        driver.findElements(lblTitle).stream().forEach(elemetn -> System.out.println(elemetn.getText()));
        System.out.println("_________");
        System.out.println(driver.findElement(lblTitle).getText());
        //Assertions.assertThat(count).isTrue();
    }

    @Test (priority = 0)
    public void test2() {

    }

    @AfterTest
    public void tearDown() {
        driver.quit(); // Закрыть браузер
    }
}
