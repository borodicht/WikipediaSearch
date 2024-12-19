package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipediaHomePage {
    WebDriver driver;

    public WikipediaHomePage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By SEARCH_INPUT = By.id("searchInput");
    private static final By SEARCH_BUTTON = By.cssSelector("button[type='submit']");
    String title = "//span[text()='%s']";

    public void openPage() {
        driver.get("https://www.wikipedia.org/");
    }

    public void searchFor(String keyword) {
        driver.findElement(SEARCH_INPUT).sendKeys(keyword);
        driver.findElement(SEARCH_BUTTON).click();
    }

    public boolean isResultDisplayed(String text) {
        return driver.findElement(By.xpath(String.format(title, text))).isDisplayed();
    }
}
