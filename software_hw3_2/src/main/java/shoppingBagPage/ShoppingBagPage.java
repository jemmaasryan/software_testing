package shoppingBagPage;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static locators.ShoppingBagPageLocators.*;

public class ShoppingBagPage extends BasePage {

    public ShoppingBagPage(WebDriver driver) {
        super(driver);
    }
    public int getNumberOfItemsInCart() {
        return driver.findElements(By.className(CART_ITEM_CLASS)).size();
    }

    public String getProductNameForItem(int itemIndex) {
        List<WebElement> cartItems = driver.findElements(By.className(CART_ITEM_CLASS));
        return cartItems.get(itemIndex).findElement(By.xpath(PRODUCT_NAME_XPATH)).getText();
    }
    public void goToShoppingBag() {
        WebElement cartIcon = driver.findElement(By.id("CART_ITEM_CLASS"));
        cartIcon.click();
    }
}
