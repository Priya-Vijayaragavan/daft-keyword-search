package StepDefinitions;

import PageObjectModal.DaftPageObjects;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Daft {

    public WebDriver driver;
    public DaftPageObjects daftPageObjects;

    @Given("user is to open Daft homepage {string}")
    public void user_is_to_open_daft_homepage(String string) {

        driver = new ChromeDriver();
        daftPageObjects= new DaftPageObjects(driver);
        driver.get(string);
        driver.manage().window().maximize();
        daftPageObjects.acceptCookies();
    }

    @When("search for a Sale Ad in county Dublin")
    public void search_for_SaleAd(){
        daftPageObjects.enteringLocation();
    }

    @Then("check that there are results for the selected {string}")
    public void check_that_results_for_selected(String location) throws InterruptedException {
        daftPageObjects.checkResultForSelectedLocation(location);

    }
    @And("apply {string} keyword filter")
    public void apply_keyword_filter(String keyword) throws InterruptedException {
        daftPageObjects.clickFilterTab()
                .enterTextInTheKeywordSearch(keyword);
    }
    @Then("check that there are results for that filter by checking filter count {string}")
    public void check_filter_Results(String count){
        daftPageObjects.checkFilterCount(count);
    }
    @Then("check that the filter was applied correctly by the {string} is there on that advert")
    public void check_applied_filter_keyword_on_advert(String keyword){
        daftPageObjects.openingOneOfTheSearchResult()
                .checkKeywordInTheResult(keyword);
    }

    @After
    public void closeBrowser(){
        driver.close();
    }
}
