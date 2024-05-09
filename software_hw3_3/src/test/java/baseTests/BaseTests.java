package baseTests;

import homePage.HomePage;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTests {
    protected WebDriver driver;
    public static String baseUrl = "https://www.shopcider.com/";

    public HomePage homePage;
    @Before
    public void setUp() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/ui/"), chromeOptions);
        driver.get(baseUrl);
        homePage = new HomePage(driver);
    }

//    @Test
//    public void verifyHomePageTitle() {
//        driver.get(baseUrl);
//        String expectedTitle = "Cider: Your Closet's Happy Hour"; // Expected title from website
//        String actualTitle = driver.getTitle();
//        assertEquals(expectedTitle, actualTitle);
//    }

//    @Test
//    public void navigateToURL() {
//        driver.navigate().to(baseUrl);
//        driver.navigate().back();
//    }

//    @After
//    public static void tearDown() {
//        BaseTests wait = null;
//        wait.driver.quit();}
}
