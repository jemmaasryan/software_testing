package homePage;

import ProductPage.ProductPage;
import basePage.BasePage;
import locators.HomePageLocators;
import locators.ProductPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHeaderLogo() {
        return BasePage.findElement(driver, By.xpath("//img[@alt='Shop Cider']"));
    }

    public HomePage getHomeMenuLink() {
        WebElement homeMenuLink = BasePage.findElement(driver, By.xpath("//a[text()='Home']"));
        homeMenuLink.click();
        return this;
    }

    public HomePage searchForProduct(String productName) {
        WebElement searchBar = BasePage.findElement(driver, HomePageLocators.SEARCH_INPUT);
        searchBar.sendKeys(productName);
        WebElement searchButton = BasePage.findElement(driver, HomePageLocators.SEARCH_BUTTON);
        searchButton.click();
        return this;
    }
    public ProductPage click() {
        WebElement productLink = BasePage.findElement(driver, ProductPageLocators.PRODUCT_LINK);
        productLink.click();
        return new ProductPage(driver);
    }
}
