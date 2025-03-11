package SPAStepDefinition;

import Core.BrowserHelper;
import SearchPage.DivisionPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class DivisionStepDefinition {
    public static WebDriver driver;
    DivisionPage divisionPage;
    @Given("user in the home page")
    public void userInTheHomePage() {
        BrowserHelper bhp = new BrowserHelper();
        driver = bhp.chrome();
        
    }
    @When("user enter with valid credential")
    public void userEnterWithValidCredential() {
        divisionPage = new DivisionPage(driver);
        divisionPage.login();
    }

    @And("user click MIS button and Setup button")
    public void userClickMISButtonAndSetupButton() {
        divisionPage.clickMISandSetup();

    }
    @And("user click on division")
    public void userClickOnDivision() {
        divisionPage.clickDivision();
    }
    @And("user click on add division")
    public void userClickOnAddDivision() throws InterruptedException {
        divisionPage.addDivisionButton();
        
    }

    @And("user enter division name, division code")
    public void userEnterDivisionNameDivisionCode() throws IOException, InvalidFormatException, InterruptedException {
        divisionPage.addInformation();
        
    }

    @And("click on submit button")
    public void clickOnSubmitButton() {
        
    }

    @Then("successfully create the division information")
    public void successfullyCreateTheDivisionInformation() {
        System.out.println("Successfully create the division information");
    }


}
