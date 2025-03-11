package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features/16_factoryInfo.feature"},
        tags = "@factoryInfo",
        glue = {"SPAStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/factoryInfoFeature.html",
               // "json:build/reports/allFeature.json"

        })

@Test
public class FactoryInfoRunnerTest extends AbstractTestNGCucumberTests {


}