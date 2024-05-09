package locators;

import org.openqa.selenium.By;

public class HomePageLocators {

    public static final By HOME_PAGE_HEADER = By.id("cider-top-nav-header");
    public static final By HOME_PAGE_HEADER_XPATH = By.id("//*[@id=\"app\"]/div/div/div[1]");

    public static final By HOME_PAGE_RECOMMENDATION_TITLE_CLASS = By.id("lazy-load-component");
    public static final By HOME_PAGE_RECOMMENDATION_TITLE_XPATH = By.id("//*[@id=\"app\"]/div/div/div[10]/div[1]/div/div/div/div[6]/div");

    public static final By SEARCH_INPUT = By.id("SEARCH_INPUT_CLASS");
    public static final By SEARCH_BUTTON = By.id("SEARCH_BUTTON_CLASS");

}
