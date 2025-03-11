package SPAStepDefinition;

import SearchPage.CustomerInfoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static SPAStepDefinition.DivisionStepDefinition.driver;

public class CustomerInfoStepDefinition {

    CustomerInfoPage customerInfoPage;
    @And("user click on customer info")
    public void userClickOnCustomerInfo() {
        customerInfoPage = new CustomerInfoPage(driver);
        customerInfoPage.clickCustomerInfo();
        
    }

    @And("user click on add customer info")
    public void userClickOnAddCustomerInfo() {
        customerInfoPage.addCustomerButton();
        
    }

    @And("user enter customer code, customer name, address and others information")
    public void userEnterCustomerCodeCustomerNameAddressAndOthersInformation() throws IOException, InterruptedException {
        customerInfoPage.addInformation();
        
    }

    @Then("successfully create the customer info information")
    public void successfullyCreateTheCustomerInfoInformation() {
        System.out.println("Successfully create the customer info information");
    }
}
