package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import movies.MoviesPage;
import org.testng.Assert;
import tests.TestsBase;

import java.net.MalformedURLException;

public class movieCastDetails extends TestsBase {

    MoviesPage moviesPage;

    @Given("Click on  a first movie")
    public void clickOnAFirstMovie() throws MalformedURLException {
        var driver = setUp();
        moviesPage = new MoviesPage(driver);
        waitForVisibility(moviesPage.getFirstMovie());
        moviesPage.getFirstMovie().click();
    }
    @When("click on second cast member")
    public void clickOnSecondCastMember() {
        waitForVisibility(moviesPage.getCastMember());
        moviesPage.getCastMember().click();
    }

    @Then("Cast member biography screen is opened")
    public void castMemberBiographyScreenIsOpened() {
        waitForVisibility(moviesPage.getActorDetails());
        Assert.assertEquals(moviesPage.getBioHeading().getText(), "BIOGRAPHY");
        Assert.assertTrue(moviesPage.getActorDetails().isDisplayed());
        tearDown();
    }
}
