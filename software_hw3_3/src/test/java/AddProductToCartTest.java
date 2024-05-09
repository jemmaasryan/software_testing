import ProductPage.ProductPage;
import baseTests.BaseTests;
import homePage.HomePage;
import org.junit.Before;
import org.junit.Test;
import shoppingBagPage.ShoppingBagPage;

import static org.junit.Assert.*;

public class AddProductToCartTest extends BaseTests {

    private HomePage homePage;
    private ShoppingBagPage shoppingBagPage;

    @Before
    public void setUp() {
        homePage = new HomePage(driver);
        shoppingBagPage = new ShoppingBagPage(driver);
    }

    @Test
    public void testAddProductToCart() {
        String productName = "Cardigan";

        ProductPage productPage = homePage.getHomeMenuLink().click();

        homePage.searchForProduct("Search for a specific product name");

        productPage.waitForProductPageToLoad();

        String displayedProductName = productPage.getProductName();
        assertEquals(productName, displayedProductName, "Product name mismatch on product page");

        productPage.addToCart();

        shoppingBagPage.goToShoppingBag();

        int numItemsInCart = shoppingBagPage.getNumberOfItemsInCart();
        assertTrue("No items found in shopping bag", numItemsInCart > 0);

        String itemName = shoppingBagPage.getProductNameForItem(0);
        assertEquals(productName, itemName, "Product name mismatch in shopping bag");
    }
}
