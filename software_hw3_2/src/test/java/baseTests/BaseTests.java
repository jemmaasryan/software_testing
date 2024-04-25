package baseTests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {
    protected WebDriver driver;
    public static String baseUrl = "https://www.shopcider.com/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.shopcider.com/");
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

    @After
    public static void tearDown() {
        BaseTests wait = null;
        wait.driver.quit();}
}
