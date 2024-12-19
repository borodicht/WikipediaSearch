package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.WikipediaHomePage;

import java.time.Duration;

public class WikipediaSteps {

    WebDriver driver;
    WikipediaHomePage homePage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new WikipediaHomePage(driver);
    }

    @Given("I am on the Wikipedia homepage")
    public void iAmOnTheWikipediaHomepage() {
        homePage.openPage();
    }

    @When("I search for {string}")
    public void iSearchFor(String keyword) {
        homePage.searchFor(keyword);
    }

    @Then("I should see results containing {string}")
    public void iShouldSeeResultsContaining(String expectedText) {
        Assert.assertTrue(homePage.isResultDisplayed(expectedText), "Expected text not found in results");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
