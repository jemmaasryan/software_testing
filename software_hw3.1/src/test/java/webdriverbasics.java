import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webdriverbasics {
    public static WebDriver driver;
    public static String baseUrl = "https://audio-joiner.com/";

    @BeforeClass
    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void navigateToURL() {
        driver.navigate().to(baseUrl);
        driver.navigate().back();
    }
    @Test
    public void WebDriverHelloWorldTest() {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver" + Keys.ENTER);
    }
    @Test
    public void WebDriverNavigationTest() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("Current Page Title: " + title);
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();
    }
}