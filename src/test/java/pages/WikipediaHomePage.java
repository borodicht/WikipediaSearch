package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Objects;

public class WikipediaHomePage {
    WebDriver driver;

    public WikipediaHomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchInput = By.id("searchInput");
    private By searchButton = By.cssSelector("button[type='submit']");
    String title = "//span[text()='%s']";

    public void navigateToHomePage() {
        driver.get("https://www.wikipedia.org/");
    }

    public void searchFor(String query) {
        driver.findElement(searchInput).sendKeys(query);
        driver.findElement(searchButton).click();
    }

    public boolean isResultDisplayed(String text) {
        return driver.findElement(By.xpath(String.format(title, text))).isDisplayed();
    }
}
