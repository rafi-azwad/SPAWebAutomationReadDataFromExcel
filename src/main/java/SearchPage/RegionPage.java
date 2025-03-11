package SearchPage;

import Excel.AreaXLSUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class RegionPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public RegionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;

    }

    public void clickRegion() {
        WebElement region = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Region']")));
        region.click();

    }

    public void addRegionButton() {

        WebElement addRegion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Region']")));
        //js.executeScript("arguments[0].click()",addDivision);
        addRegion.click();


    }

    public void addInformation() throws IOException, InterruptedException {

        // Read Excel data
        String path = System.getProperty("user.dir");
        String filePath = path + "\\file\\Region.xls";
        List<String[]> testData = AreaXLSUtils.readExcelData(filePath);


        // Loop through each row

        for (String[] data : testData) {

            String code = data[0];
            String name = data[1];



            WebElement regionCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='region_code']")));
            regionCode.sendKeys(code);

            WebElement regionName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='region_name']")));
            regionName.sendKeys(name);



            //Thread.sleep(2000);
            submit();
            try {
                WebElement close = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Close']")));
                if (close.isDisplayed() && close.isEnabled()) {
                    close.click();
                }
            } catch (TimeoutException e) {
                System.out.println("Close button not found, continuing execution...");
            } catch (Exception e) {
                System.out.println("Unexpected error while closing popup: " + e.getMessage());
            }

            //Thread.sleep(1000);
            driver.navigate().refresh();
            addRegionButton();

        }
        driver.quit();
    }

    public void submit(){
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() ='Submit']")));
        submit.click();

    }

}


