package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features/02_region.feature"},
        tags = "@region",
        glue = {"SPAStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/regionFeature.html",
               // "json:build/reports/allFeature.json"

        })

@Test
public class RegionRunnerTest extends AbstractTestNGCucumberTests {


}