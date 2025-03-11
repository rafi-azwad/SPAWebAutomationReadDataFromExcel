package SPAStepDefinition;

import SearchPage.RetailerInfoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static SPAStepDefinition.DivisionStepDefinition.driver;

public class RetailerInfoStepDefinition {

    RetailerInfoPage retailerInfoPage;


    @And("user click on retailer info")
    public void userClickOnRetailerInfo() {
        retailerInfoPage = new RetailerInfoPage(driver);
        retailerInfoPage.clickRetailerInfo();
        
    }

    @And("user click on add retailer info")
    public void userClickOnAddRetailerInfo() {
        retailerInfoPage.addRetailerInfo();
        
    }

    @And("user enter retailer code, retailer name and all information")
    public void userEnterRetailerCodeRetailerNameAndAllInformation() throws IOException, InterruptedException {
        retailerInfoPage.addInformation();
        
    }

    @Then("successfully create the retailer info information")
    public void successfullyCreateTheRetailerInfoInformation() {
        System.out.println("Successfully create the retailer information");

    }


}
