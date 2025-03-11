package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features/06_marketSegment.feature"},
        tags = "@marketSegment",
        glue = {"SPAStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/marketSegmentFeature.html",
               // "json:build/reports/allFeature.json"

        })

@Test
public class MarketSegmentRunnerTest extends AbstractTestNGCucumberTests {


}