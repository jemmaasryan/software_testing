package locators;

import org.openqa.selenium.By;

public class ProductPageLocators {
    public static final By PRODUCT_NAME = By.id("product-detail-title");
    public static final By PRODUCT_NAME_XPATH = By.xpath("//*[@id=\"app\"]/div/div/div[10]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]");
    public static final By PRODUCT_LINK = By.cssSelector("product-list-item-box");
    public static final String PRODUCT_IMAGE_CLASS = "product-intro_wrap";
    public static final String PRODUCT_IMAGE_XPATH = "//*[@id=\"app\"]/div/div/div[10]/div[2]/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div[1]";

    public static final String PRODUCT_PRICE_CLASS = "price-main f-black";
    public static final String PRODUCT_PRICE_XPATH = "//*[@id=\"app\"]/div/div/div[10]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]";

    public static final By ADD_TO_CART_BUTTON_CLASS = By.id("cider-button cursor-pointer button-large is-bold");
    public static final String ADD_TO_CART_BUTTON_XPATH = "//*[@id=\"app\"]/div/div/div[10]/div[2]/div/div/div[2]/div[1]/div[2]/div[8]";
}
