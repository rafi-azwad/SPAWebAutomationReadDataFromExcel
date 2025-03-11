package SPAStepDefinition;

import SearchPage.MarketSegmentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static SPAStepDefinition.DivisionStepDefinition.driver;

public class MarketSegmentStepDefinition {
    MarketSegmentPage marketSegmentPage;
    @And("user click on market segment")
    public void userClickOnMarketSegment() {
        marketSegmentPage = new MarketSegmentPage(driver);
        marketSegmentPage.clickMarketSegment();
        
    }

    @And("user click on add market segment")
    public void userClickOnAddMarketSegment() {
        marketSegmentPage.addMarketSegment();
        
    }

    @And("user enter market segment code, name and address")
    public void userEnterMarketSegmentCodeNameAndAddress() throws IOException, InterruptedException {
        marketSegmentPage.addInformation();
        
    }

    @Then("successfully create the market segment information")
    public void successfullyCreateTheMarketSegmentInformation() {
        System.out.println("Successfully create the segment information");
    }
}
