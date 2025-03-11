package SearchPage;


import Excel.RetailerCategoryCSVUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class RetailerCategoryPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public RetailerCategoryPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;


    }
    public void clickRetailerCategory() {
        WebElement category = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Retailer Category']")));
        category.click();

    }

    public void addRetailerCategory() {

        WebElement addCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Retailer Category']")));
        //js.executeScript("arguments[0].click()",addDivision);
        addCategory.click();


    }

    public void addInformation() throws IOException, InterruptedException {

        // Read Excel data
        String path = System.getProperty("user.dir");
        String filePath = path + "\\file\\RETAILER_CATEGORY_INFO.csv";
        List<String[]> testData = RetailerCategoryCSVUtils.readCSVData(filePath);


        // Loop through each row

        for (String[] data : testData) {

            String code = data[0];
            String name = data[1];



            WebElement territoryCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='categoryCode']")));
            territoryCode.sendKeys(code);

            WebElement territoryName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='categoryName']")));
            territoryName.sendKeys(name);



            //Thread.sleep(2000);
            submit();


            //Thread.sleep(1000);
            driver.navigate().refresh();
            addRetailerCategory();

        }
        driver.quit();
    }

    public void submit(){
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() ='Submit']")));
        submit.click();

    }

}
