package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features/11_categoryInfo.feature"},
        tags = "@categoryInfo",
        glue = {"SPAStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/categoryInfoFeature.html",
               // "json:build/reports/allFeature.json"

        })

@Test
public class CategoryInfoRunnerTest extends AbstractTestNGCucumberTests {


}