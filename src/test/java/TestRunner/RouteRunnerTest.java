package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features/07_route.feature"},
        tags = "@route",
        glue = {"SPAStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/routeFeature.html",
               // "json:build/reports/allFeature.json"

        })

@Test
public class RouteRunnerTest extends AbstractTestNGCucumberTests {


}