package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features/15_priceInfo.feature"},
        tags = "@priceInfo",
        glue = {"SPAStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/priceInfoFeature.html",
               // "json:build/reports/allFeature.json"

        })

@Test
public class PriceInfoRunnerTest extends AbstractTestNGCucumberTests {


}