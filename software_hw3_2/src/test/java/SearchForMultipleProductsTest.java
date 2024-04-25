import ProductPage.ProductPage;
import baseTests.BaseTests;
import homePage.HomePage;
import org.junit.Test;
import shoppingBagPage.ShoppingBagPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchForMultipleProductsTest extends BaseTests {
    private HomePage homePage;
    private ProductPage productPage;
    private ShoppingBagPage shoppingBagPage;

    @Test
    public void testSearchForMultipleProducts() {
        String product1 = "Jeans";
        String product2 = "Tops";

        homePage.getHomeMenuLink().click();
        homePage.searchForProduct("Search for a specific product name");
        productPage.waitForProductPageToLoad();

        String displayedProductName = productPage.getProductName();
        assertEquals(product1, displayedProductName, "Product name mismatch on product page");
        assertEquals(product2, displayedProductName, "Product name mismatch on product page");
        productPage.addToCart();

        shoppingBagPage.goToShoppingBag();


        int numItemsInCart = shoppingBagPage.getNumberOfItemsInCart();
        assertTrue("No items found in shopping bag", numItemsInCart > 0);

        String itemName = shoppingBagPage.getProductNameForItem(0);
        assertEquals(product1, itemName, "Product name mismatch in shopping bag");
        assertEquals(product2, displayedProductName, "Product name mismatch on product page");
    }

}
