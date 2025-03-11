package SearchPage;

import Excel.MarketSegmentXLSUtils;
import Excel.TerritoryXLSUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class MarketSegmentPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public MarketSegmentPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;


    }
    public void clickMarketSegment() {
        WebElement segment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Market Segment']")));
        segment.click();

    }

    public void addMarketSegment() {

        WebElement addSegment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Market Segment']")));
        //js.executeScript("arguments[0].click()",addDivision);
        addSegment.click();


    }

    public void addInformation() throws IOException, InterruptedException {

        // Read Excel data
        String path = System.getProperty("user.dir");
        String filePath = path + "\\file\\MARKET_SEGMENT_INFO.xls";
        List<String[]> testData = MarketSegmentXLSUtils.readXLSXData(filePath);


        // Loop through each row

        for (String[] data : testData) {

            String code = data[0];
            String name = data[1];
            String address = data[2];


            WebElement segmentCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='market_segment_code']")));
            segmentCode.sendKeys(code);

            WebElement segmentName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='market_segment_name']")));
            segmentName.sendKeys(name);

            WebElement address1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='market_segment_address']")));
            address1.sendKeys(address);



            //Thread.sleep(2000);
            submit();


            //Thread.sleep(1000);
            driver.navigate().refresh();
            addMarketSegment();

        }
        driver.quit();
    }

    public void submit(){
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() ='Submit']")));
        js.executeScript("arguments[0].click();", submit);

    }

}
