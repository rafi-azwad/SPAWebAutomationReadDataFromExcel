package SPAStepDefinition;

import SearchPage.MarketPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static SPAStepDefinition.DivisionStepDefinition.driver;

public class MarketStepDefinition {

    MarketPage marketPage;
    @And("user click on market")
    public void userClickOnMarket() {
        marketPage = new MarketPage(driver);
        marketPage.clickMarket();
        
    }

    @And("user click on add market")
    public void userClickOnAddMarket() {
        marketPage.addMarket();
        
    }

    @And("user enter market code, name and other information")
    public void userEnterMarketCodeNameAndOtherInformation() throws IOException, InterruptedException {
        marketPage.addInformation();
    }

    @Then("successfully create the market information")
    public void successfullyCreateTheMarketInformation() {
        System.out.println("Successfully create the market information");
    }
}
