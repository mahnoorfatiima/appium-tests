package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import movies.MoviesPage;
import org.testng.Assert;
import tests.TestsBase;

import java.net.MalformedURLException;

public class searchForMovie extends TestsBase {

    MoviesPage moviesPage;
    String textSearch = "Forrest Gump";
    @Given("Click on search bar")
    public void clickOnSearchBar() throws MalformedURLException {
        var driver = setUp();
        moviesPage = new MoviesPage(driver);
        waitForVisibility(moviesPage.getSelectedMenu());
        moviesPage.getSearchBar().click();
    }

    @When("Add movie name to be searched")
    public void addMovieNameToBeSearched() {
        moviesPage.getSearchBar().sendKeys(textSearch + "\n");
    }

    @Then("Movie with similar name appears in the list")
    public void movieWithSimilarNameAppearsInTheList() {
        waitForVisibility(moviesPage.getSearchedFirstMovie());
        Assert.assertEquals(moviesPage.getSearchedFirstMovie().getText(), textSearch);
        tearDown();
    }
}
