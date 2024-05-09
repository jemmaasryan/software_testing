package locators;

import org.openqa.selenium.By;

public class ShoppingBagPageLocators {

    //public static final String CART_NAME_CLASS = "title-view";
    public static final By CART_ITEM_CLASS = By.id("cart-product-item-container is-cart-page");

    public static final By PRODUCT_NAME_XPATH = By.id("//*[@id=\"app\"]/div/div/div[10]/div[2]/div/div[1]/div[2]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[1]");
    public static final String QUANTITY_INPUT_ID = "quantity-input";
    public static final String TOTAL_PRICE_XPATH = "TOTAL_PRICE_XPATH";
    public static final String CHECKOUT_BUTTON_ID = "checkout-button";
}
