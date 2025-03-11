package SPAStepDefinition;

import SearchPage.AreaPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static SPAStepDefinition.DivisionStepDefinition.driver;


public class AreaStepDefinition {
    AreaPage areaPage;

    @And("user click on area")
    public void userClickOnArea() {
        areaPage = new AreaPage(driver);
        areaPage.clickArea();
    }
    @And("user click on add area")
    public void userClickOnAddArea() {

        areaPage.addAreaButton();
        
    }

    @And("user enter area code, name and remarks")
    public void userEnterAreaCodeNameAndRemarks() throws IOException, InterruptedException {
        areaPage.addInformation();
    }

    @Then("successfully create the area information")
    public void successfullyCreateTheAreaInformation() {
    }


}
