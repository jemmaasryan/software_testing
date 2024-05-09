import ProductPage.ProductPage;
import baseTests.BaseTests;
import homePage.HomePage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import shoppingBagPage.ShoppingBagPage;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class NavigateSimilarProductTest extends BaseTests {
    private HomePage homePage;
    private ProductPage productPage2;
    private ShoppingBagPage shoppingBagPage;


    @Test
    public void testNavigateSimilarProductAndAddToCart() throws Exception {
        String productName = "Dresses";
        homePage = new HomePage(driver);
        homePage.searchForProduct(productName);

        ProductPage productPage1 = homePage.waitForProductPageToLoad();
        productPage1.clickProduct();

        productPage2 = navigateToSimilarProduct(productPage1);
        productPage2.addToCart();
        shoppingBagPage.goToShoppingBag();

        int numItemsInCart = shoppingBagPage.getNumberOfItemsInCart();
        assertTrue("No items found in shopping bag", numItemsInCart > 0);
    }

    private ProductPage navigateToSimilarProduct(ProductPage productPage1) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            List<WebElement> similarProducts = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(text(), 'You might also like')]")));
            if (!similarProducts.isEmpty()) {
                similarProducts.get(0).click(); //remove, add in POM

                wait.until(ExpectedConditions.titleContains("Product"));
                return new ProductPage(driver);
            } else {
                throw new Exception("No similar products found");
            }
        } catch (TimeoutException e) {
                throw new Exception("Timed out waiting for similar products", e);
        }
    }
}
