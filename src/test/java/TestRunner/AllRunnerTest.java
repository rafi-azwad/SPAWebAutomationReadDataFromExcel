package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features"},

        tags = "@login or @orderRetailer or @invoiceRetailer or @invoiceDisplay or " +
                "@invoiceReturnFromRetailer or @requisitionToFactory or @replacementSummarySheet or " +
                "@damageStockTransferForReplacement or @shortProducts or @retailerDisplayProgramParticipation",

        glue = {"SPAStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/allFeature.html",
                //"json:build/reports/allFeature.json"
        })

@Test
public class AllRunnerTest extends AbstractTestNGCucumberTests {


}
