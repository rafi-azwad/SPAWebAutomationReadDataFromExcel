package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features/09_retailerCategory.feature"},
        tags = "@retailerCategory",
        glue = {"SPAStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/retailerCategoryFeature.html",
               // "json:build/reports/allFeature.json"

        })

@Test
public class RetailerCategoryRunnerTest extends AbstractTestNGCucumberTests {


}