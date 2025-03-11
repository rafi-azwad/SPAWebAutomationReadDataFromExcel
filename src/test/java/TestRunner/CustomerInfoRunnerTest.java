package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features/08_customerInfo.feature"},
        tags = "@customerInfo",
        glue = {"SPAStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/customerInfoFeature.html",
               // "json:build/reports/allFeature.json"

        })

@Test
public class CustomerInfoRunnerTest extends AbstractTestNGCucumberTests {


}