package ProductPage;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static locators.ProductPageLocators.*;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public String getProductName() {
        return driver.findElement(PRODUCT_NAME_XPATH).getText();
    }

    public String getProductPrice() {
        return driver.findElement(By.xpath(PRODUCT_PRICE_XPATH)).getText();
    }

    public void addToCart() {
        BasePage.findElement(driver, ADD_TO_CART_BUTTON_CLASS).click();
    }

    public void clickProduct() {
    }
}
