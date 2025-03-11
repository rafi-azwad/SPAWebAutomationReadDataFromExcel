package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features/10_brandInfo.feature"},
        tags = "@brandInfo",
        glue = {"SPAStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/brandInfoFeature.html",
               // "json:build/reports/allFeature.json"

        })

@Test
public class BrandInfoRunnerTest extends AbstractTestNGCucumberTests {


}