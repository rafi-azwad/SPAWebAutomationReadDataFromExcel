package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features/01_division.feature"},
        tags = "@division",
        glue = {"SPAStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/divisionFeature.html",
               // "json:build/reports/allFeature.json"

        })

@Test
public class DivisionRunnerTest extends AbstractTestNGCucumberTests {


}