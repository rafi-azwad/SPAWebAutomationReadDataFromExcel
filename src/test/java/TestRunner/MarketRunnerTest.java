package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features/05_market.feature"},
        tags = "@market",
        glue = {"SPAStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/marketFeature.html",
               // "json:build/reports/allFeature.json"

        })

@Test
public class MarketRunnerTest extends AbstractTestNGCucumberTests {


}