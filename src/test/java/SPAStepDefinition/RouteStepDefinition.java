package SPAStepDefinition;

import SearchPage.RoutePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static SPAStepDefinition.DivisionStepDefinition.driver;

public class RouteStepDefinition {

    RoutePage routePage;
    @And("user click on route")
    public void userClickOnRoute() {

        routePage = new RoutePage(driver);
        routePage.clickRoute();
        
    }

    @And("user click on add route")
    public void userClickOnAddRoute() throws InterruptedException {
        routePage.addRouteButton();

    }

    @And("user enter route code, route name, address and remarks")
    public void userEnterRouteCodeRouteNameAddressAndRemarks() throws IOException, InterruptedException {
        routePage.addInformation();

    }

    @Then("successfully create the route information")
    public void successfullyCreateTheRouteInformation() {

        System.out.println("Successfully create the route information");
    }
}
