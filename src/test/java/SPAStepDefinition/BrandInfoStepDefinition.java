package SPAStepDefinition;

import SearchPage.BrandInfoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static SPAStepDefinition.DivisionStepDefinition.driver;

public class BrandInfoStepDefinition {

    BrandInfoPage brandInfoPage;
    @And("user click on brand info")
    public void userClickOnBrandInfo() {
        brandInfoPage = new BrandInfoPage(driver);
        brandInfoPage.clickBrandInfo();
        
    }

    @And("user click on add brand info")
    public void userClickOnAddBrandInfo() {
        brandInfoPage.addBrandInfo();
        
    }

    @And("user enter brand code, brand name, brand type and remarks")
    public void userEnterBrandCodeBrandNameBrandTypeAndRemarks() throws IOException, InterruptedException {
        brandInfoPage.addInformation();
        
    }

    @Then("successfully create the brand info information")
    public void successfullyCreateTheBrandInfoInformation() {
        System.out.println("Successfully create the brand information");
    }
}
