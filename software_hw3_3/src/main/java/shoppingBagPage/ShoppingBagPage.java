package shoppingBagPage;

import basePage.BasePage;
import locators.ShoppingBagPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static locators.ShoppingBagPageLocators.*;

public class ShoppingBagPage extends BasePage {

    public ShoppingBagPage(WebDriver driver) {
        super(driver);
    }
    public int getNumberOfItemsInCart() {
        return driver.findElements(CART_ITEM_CLASS).size();
    }

    public String getProductNameForItem(int itemIndex) {
        List<WebElement> cartItems = driver.findElements(CART_ITEM_CLASS);
        return cartItems.get(itemIndex).findElement(ShoppingBagPageLocators.PRODUCT_NAME_XPATH).getText();
    }
    public void goToShoppingBag() {
        WebElement cartIcon = BasePage.findElement(driver, CART_ITEM_CLASS);
        cartIcon.click();
    }
}
