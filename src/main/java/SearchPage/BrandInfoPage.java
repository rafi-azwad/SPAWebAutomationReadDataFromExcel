package SearchPage;


import Excel.BrandInfoCSVUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BrandInfoPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public BrandInfoPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;


    }
    public void clickBrandInfo() {
        WebElement brand = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Brand Info']")));
        brand.click();

    }

    public void addBrandInfo() {

        WebElement addCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Brand']")));
        //js.executeScript("arguments[0].click()",addDivision);
        addCategory.click();


    }

    public void addInformation() throws IOException, InterruptedException {

        // Read Excel data
        String path = System.getProperty("user.dir");
        String filePath = path + "\\file\\BRAND_INFO.csv";
        //List<String[]> testData = BrandInfoExcelUtils.readExcelData(filePath);
        List<String[]> testData = BrandInfoCSVUtils.readCSVData(filePath);


        // Loop through each row

        for (String[] data : testData) {

            String code = data[0];
            String name = data[1];
            String type = data[2];
            String remark = data[3];



            WebElement brandCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='brandCode']")));
            brandCode.sendKeys(code);

            WebElement brandName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='brandName']")));
            brandName.sendKeys(name);

            WebElement brandType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='brandType']")));
            brandType.sendKeys(type);

            WebElement brandRemarks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='remarks']")));
            brandRemarks.sendKeys(remark);



            //Thread.sleep(2000);
            submit();
        /*    try {
                WebElement close = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Close']")));
                if (close.isDisplayed() && close.isEnabled()) {
                    close.click();
                }
            } catch (TimeoutException e) {
                System.out.println("Close button not found, continuing execution...");
            } catch (Exception e) {
                System.out.println("Unexpected error while closing popup: " + e.getMessage());
            }*/

            //Thread.sleep(1000);
            driver.navigate().refresh();
            addBrandInfo();

        }
        driver.quit();
    }

    public void submit(){
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() ='Submit']")));
        submit.click();

    }

}
