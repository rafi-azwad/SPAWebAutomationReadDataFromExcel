package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features/13_retailerInfo.feature"},
        tags = "@retailerInfo",
        glue = {"SPAStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/retailerInfoFeature.html",
               // "json:build/reports/allFeature.json"

        })

@Test
public class RetailerInfoRunnerTest extends AbstractTestNGCucumberTests {


}