package basePage;

import ProductPage.ProductPage;
import locators.ProductPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    };

    public ProductPage waitForProductPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(ProductPageLocators.PRODUCT_NAME));

        return new ProductPage(driver);
    }
    public static WebElement findElement(WebDriver driver, By elementId) {
        return driver.findElement(elementId);
    }

}
