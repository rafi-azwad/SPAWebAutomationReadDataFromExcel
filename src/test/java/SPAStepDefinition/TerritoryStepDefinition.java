package SPAStepDefinition;

import SearchPage.TerritoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static SPAStepDefinition.DivisionStepDefinition.driver;

public class TerritoryStepDefinition {

    TerritoryPage territoryPage;
    @And("user click on territory")
    public void userClickOnTerritory() {
        territoryPage = new TerritoryPage(driver);
        territoryPage.clickTerritory();
    }

    @And("user click on add territory")
    public void userClickOnAddTerritory() {
        territoryPage.addTerritoryButton();

    }

    @And("user enter territory code, territory name, address and remarks")
    public void userEnterTerritoryCodeTerritoryNameAddressAndRemarks() throws IOException, InterruptedException {
        territoryPage.addInformation();

    }

    @Then("successfully create the territory information")
    public void successfullyCreateTheTerritoryInformation() {
        System.out.println("Successfully create the territory information");
    }
}
