package SPAStepDefinition;

import SearchPage.RegionPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static SPAStepDefinition.DivisionStepDefinition.driver;

public class RegionStepDefinition {

    RegionPage regionPage;
    @And("user click on region")
    public void userClickOnRegion() {
        regionPage = new RegionPage(driver);
        regionPage.clickRegion();

    }

    @And("user click on add region")
    public void userClickOnAddRegion() {
        regionPage.addRegionButton();

    }

    @And("user enter region code, region name")
    public void userEnterRegionCodeRegionName() throws IOException, InterruptedException {
        regionPage.addInformation();

    }

    @Then("successfully create the region information")
    public void successfullyCreateTheRegionInformation() {
        System.out.println("Successfully Create the region information");
    }
}
