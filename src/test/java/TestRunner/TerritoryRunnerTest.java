package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features/04_territory.feature"},
        tags = "@territory",
        glue = {"SPAStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/territoryFeature.html",
               // "json:build/reports/allFeature.json"

        })

@Test
public class TerritoryRunnerTest extends AbstractTestNGCucumberTests {


}