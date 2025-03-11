package SearchPage;

import Excel.CategoryInfoXLSUtils;
import Excel.ProductInfoXLSUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class ProductInfoPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public ProductInfoPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;


    }
    public void clickProductInfo() {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Product Info']")));
        product.click();

    }

    public void addProductButton() {

        WebElement addProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Product INFO']")));
        //js.executeScript("arguments[0].click()",addDivision);
        addProduct.click();


    }

    public void addInformation() throws IOException, InterruptedException {

        // Read Excel data
        String path = System.getProperty("user.dir");
        String filePath = path + "\\file\\Product.xls";
        List<String[]> testData = ProductInfoXLSUtils.readExcelData(filePath);


        // Loop through each row

        for (String[] data : testData) {

            String code = data[0];
            String name = data[1];
            String packSize = data[2];
            String baseProduct = data[3];
            String brandName = data[4];
            String categoryName = data[5];
            String discountType = data[6];
            String shipperQTY = data[7];


            WebElement productCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='productCode']")));
            productCode.sendKeys(code);

            WebElement productName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='productName']")));
            productName.sendKeys(name);

            WebElement size = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='packSize']")));
            size.sendKeys(packSize);


            WebElement baseDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Base Product']//following::input[1]")));
            js.executeScript("arguments[0].click()",baseDropdown);
            baseDropdown.click();

            // Click dropdown to open options

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> base = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li")));


            String baseList = baseProduct.trim(); // Change this to the required value

            //String baseList = baseProduct.replace("\u00A0", " ").trim(); // Trim to remove extra spaces

            for (WebElement option : base) {
                if (option.getText().trim().equals(baseList)) {
                    option.click();
                    break;
                }
            }

            WebElement brandDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Brand']//following::input[1]")));
            js.executeScript("arguments[0].click()",brandDropdown);
            brandDropdown.click();


            // Click dropdown to open options
// Wait for the dropdown options to appear
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            List<WebElement> brand = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li")));

// Select an option by text
            String brandList = brandName.trim();
            for (WebElement option : brand) {
                if (option.getText().trim().equals(brandList)) {
                    option.click();
                    break;
                }
            }


            WebElement categoryDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Category']//following::input[1]")));
            js.executeScript("arguments[0].click()",categoryDropdown);
            categoryDropdown.click();


            // Click dropdown to open options
// Wait for the dropdown options to appear
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            List<WebElement> category = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li")));

// Select an option by text
            String categoryList = categoryName.trim(); // Change this to the required value
            for (WebElement option : category) {
                if (option.getText().trim().equals(categoryList)) {
                    option.click();
                    break;
                }
            }

            if(discountType.equals("F")) {
                WebElement type = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Discount Type']//following:: div[1]")));
                type.click();

                List<WebElement> discount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//ul[@role='listbox']//li")));

// Select an option by text
                String discountList = "Taka"; // Change this to the required value
                for (WebElement option : discount) {
                    if (option.getText().trim().equals(discountList)) {
                        option.click();
                        break;
                    }
                }
            }

            WebElement shipper = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='shipperQty']")));
            shipper.clear();
            shipper.sendKeys(shipperQTY);

            submit();

            driver.navigate().refresh();
            addProductButton();

        }
        driver.quit();
    }

    public void submit(){
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() ='Submit']")));

        js.executeScript("arguments[0].click()",submit);

    }

}
