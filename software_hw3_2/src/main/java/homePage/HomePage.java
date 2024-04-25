package homePage;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static locators.SearchPageLocators.*;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public WebElement getHeaderLogo() {
        return driver.findElement(By.xpath("//img[@alt='Shop Cider']"));
    }

    public WebElement getHomeMenuLink() {
        return driver.findElement(By.xpath("//a[text()='Home']"));
    }

    public void searchForProduct(String productName) {
        WebElement searchBar = driver.findElement(By.id("SEARCH_INPUT_CLASS"));
        searchBar.sendKeys(productName);
        WebElement searchButton = driver.findElement(By.id("SEARCH_BUTTON_CLASS"));
        searchButton.click();
    }
}
