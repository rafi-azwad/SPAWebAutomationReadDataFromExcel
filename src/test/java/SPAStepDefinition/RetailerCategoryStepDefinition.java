package SPAStepDefinition;

import SearchPage.RetailerCategoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static SPAStepDefinition.DivisionStepDefinition.driver;

public class RetailerCategoryStepDefinition {

    RetailerCategoryPage retailerCategoryPage;
    @And("user click on retailer category")
    public void userClickOnRetailerCategory() {
        retailerCategoryPage = new RetailerCategoryPage(driver);
        retailerCategoryPage.clickRetailerCategory();
        
    }

    @And("user click on add retailer category")
    public void userClickOnAddRetailerCategory() {
        retailerCategoryPage.addRetailerCategory();
        
    }

    @And("user enter retailer category code, retailer category name")
    public void userEnterRetailerCategoryCodeRetailerCategoryName() throws IOException, InterruptedException {
        retailerCategoryPage.addInformation();
    }

    @Then("successfully create the retailer category information")
    public void successfullyCreateTheRetailerCategoryInformation() {

        System.out.println("Successfully create the retailer category information");
    }


}
