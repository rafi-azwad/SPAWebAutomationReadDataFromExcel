package SPAStepDefinition;

import SearchPage.PriceInfoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static SPAStepDefinition.DivisionStepDefinition.driver;

public class PriceInfoStepDefinition {

    PriceInfoPage priceInfoPage;
    @And("user click on price info")
    public void userClickOnPriceInfo() {

        priceInfoPage = new PriceInfoPage(driver);
        priceInfoPage.clickPrice();

    }

    @And("user click on add price info")
    public void userClickOnAddPriceInfo() {
        priceInfoPage.addPriceButton();
    }

    @And("user enter price date, retailer code and other information")
    public void userEnterPriceDateRetailerCodeAndOtherInformation() throws IOException, InterruptedException {
        priceInfoPage.addInformation();
    }

    @Then("successfully create the price info information")
    public void successfullyCreateThePriceInfoInformation() {
        System.out.println("Successfully create the price information");
    }
}
