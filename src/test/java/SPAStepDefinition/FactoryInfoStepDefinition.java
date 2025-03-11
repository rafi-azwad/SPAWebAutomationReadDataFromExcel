package SPAStepDefinition;

import SearchPage.FactoryInfoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static SPAStepDefinition.DivisionStepDefinition.driver;

public class FactoryInfoStepDefinition {

    FactoryInfoPage factoryInfoPage;
    @And("user click on factory info")
    public void userClickOnFactoryInfo() {
        factoryInfoPage = new FactoryInfoPage(driver);
        factoryInfoPage.clickFactoryInfo();

    }

    @And("user click on add factory info")
    public void userClickOnAddFactoryInfo() {
        factoryInfoPage.addFactoryInfo();

    }
    @And("user enter factory code, retailer name and address")
    public void userEnterFactoryCodeRetailerNameAndAddress() throws IOException, InterruptedException {
        factoryInfoPage.addInformation();
    }

    @Then("successfully create the factory info information")
    public void successfullyCreateTheFactoryInfoInformation() {
        System.out.println("Successfully create the factory information");
    }
}
