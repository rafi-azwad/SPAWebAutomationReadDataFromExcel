package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features/12_productInfo.feature"},
        tags = "@productInfo",
        glue = {"SPAStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/productInfoFeature.html",
               // "json:build/reports/allFeature.json"

        })

@Test
public class ProductInfoRunnerTest extends AbstractTestNGCucumberTests {


}