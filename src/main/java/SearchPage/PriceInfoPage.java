package SearchPage;

import Excel._PriceInfoXLSUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class PriceInfoPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public PriceInfoPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;


    }
    public void clickPrice() {
        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Price Info']")));
        price.click();

    }

    public void addPriceButton() {

        WebElement addPrice = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Price INFO']")));
        //js.executeScript("arguments[0].click()",addDivision);
        addPrice.click();


    }

    public void addInformation() throws IOException, InterruptedException {

        // Read Excel data
        String path = System.getProperty("user.dir");
        String filePath = path + "\\file\\PRODUCT_PRICE_INFO.xls";
        List<String[]> testData = _PriceInfoXLSUtils.readXLSData(filePath);


        // Loop through each row

        for (String[] data : testData) {

            String date = data[0];
            String code = data[1];
            String unitTP = data[2];
            String unitVat = data[3];
            String mrp = data[4];
            String employeePrice = data[5];
            String specialPrice = data[6];
            String grossProfit = data[7];


            WebElement priceDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='priceDate']")));
            priceDate.sendKeys(date);

            WebElement priceCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='productCode']")));
            priceCode.sendKeys(code);

            WebElement tp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='unitTP']")));
            if (unitTP != null && !unitTP.trim().isEmpty()) {
                tp.clear();
                tp.sendKeys(unitTP);
            }


            WebElement mrp1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='mrp']")));
            if (mrp != null && !mrp.trim().isEmpty()) {
                mrp1.clear();
                mrp1.sendKeys(mrp);
            }


            WebElement employee = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='employeePrice']")));
            if (employeePrice!= null && !employeePrice.trim().isEmpty()) {
                employee.clear();
                employee.sendKeys(employeePrice);
            }

            WebElement vat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='unitVAT']")));
            if (unitVat!= null && !unitVat.trim().isEmpty()) {
                vat.clear();
                vat.sendKeys(unitVat);
            }

            WebElement gProfit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='grossProfit']")));
            if (grossProfit!= null && !grossProfit.trim().isEmpty()) {
                gProfit.clear();
                gProfit.sendKeys(grossProfit);
            }


            WebElement sPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='specialPrice']")));

            if (specialPrice!= null && !specialPrice.trim().isEmpty()) {
                sPrice.clear();
                sPrice.sendKeys(specialPrice);
            }

            submit();

            driver.navigate().refresh();
            addPriceButton();

        }
        driver.quit();
    }

    public void submit(){
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() ='Submit']")));
        submit.click();

    }

}
