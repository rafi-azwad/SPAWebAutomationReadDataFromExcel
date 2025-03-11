package SearchPage;

import Excel.CategoryInfoXLSUtils;
import Excel.CustomerInfoXLSUtils;
import Excel.ProductInfoXLSUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CustomerInfoPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;


    private static String getValueOrRandom(String data, String prefix, int bound) {
        Random random = new Random();
        return (data != null && !data.trim().isEmpty()) ? data : prefix + random.nextInt(bound);
    }
    private static String getEmailOrNull(String data) {
        return (data != null && !data.trim().isEmpty()) ? data : "";
    }

    public CustomerInfoPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;


    }
    public void clickCustomerInfo() {
        WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Customer Info']")));
        customer.click();

    }

    public void addCustomerButton() {

        WebElement addCustomer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Customer']")));
        //js.executeScript("arguments[0].click()",addDivision);
        addCustomer.click();


    }

    public void addInformation() throws IOException, InterruptedException {

        // Read Excel data
        String path = System.getProperty("user.dir");
        String filePath = path + "\\file\\CUSTOMER_INFO.xls";
        List<String[]> testData = CustomerInfoXLSUtils.readExcelData(filePath);


        // Loop through each row

        for (String[] data : testData) {

            String code = getValueOrRandom(data[0], "", 100000);
            String name = getValueOrRandom(data[1], "name", 100000);
            String address = getValueOrRandom(data[2], "address", 100000);
            String contactPerson = getValueOrRandom(data[3], "name ", 10000);
            String contactNumber = getValueOrRandom(data[4], "", 100000);
            String email = getEmailOrNull(data[5]);
            String customerType = getValueOrRandom(data[6], "", 100000);
            String commission = getValueOrRandom(data[7], "", 1);
            String DBCode = getValueOrRandom(data[8], "", 1);
            String DBName = getValueOrRandom(data[9], "dbName ", 10000);


            WebElement customerCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='customerCode']")));
            customerCode.sendKeys(code);

            WebElement CustomerName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='customerName']")));
            CustomerName.sendKeys(name);

            WebElement customerAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='address']")));
            customerAddress.sendKeys(address);

            WebElement person = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='contactPerson']")));
            person.sendKeys(contactPerson);

            WebElement number = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='contactNo']")));
            number.sendKeys(contactNumber);

            WebElement email1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
            email1.sendKeys(email);



            WebElement proprietorDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Proprietor']//following::div[1]")));
            js.executeScript("arguments[0].click()",proprietorDropdown);
            proprietorDropdown.click();

            // Click dropdown to open options

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            List<WebElement> proprietor = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//ul[@role='listbox']//li")));

// Select an option by text
            String proprietorList = "Yes";
            for (WebElement option : proprietor) {
                if (option.getText().trim().equals(proprietorList)) {
                    js.executeScript("arguments[0].click()",option);
                    option.click();
                    break;
                }
            }

            WebElement customerTypeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Customer Type']//following::div[1]")));
            js.executeScript("arguments[0].click()",customerTypeDropdown);
            customerTypeDropdown.click();

            // Click dropdown to open options

            List<WebElement> type = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//ul[@role='listbox']//li")));

    if(customerType.equalsIgnoreCase("DI")) {

        String customerTypeList = "Distributer";
        for (WebElement option : type) {
            if (option.getText().trim().equals(customerTypeList)) {
                js.executeScript("arguments[0].click()",option);
                option.click();
                break;
            }
        }
    }
    else if(customerType.equalsIgnoreCase("OR")) {

        String customerTypeList = "Organization";
        for (WebElement option : type) {
            if (option.getText().trim().equals(customerTypeList)) {
                js.executeScript("arguments[0].click()",option);
                option.click();
                break;
            }
        }
    }
    else if(customerType.equalsIgnoreCase("EM")) {

        String customerTypeList = "Employee";
        for (WebElement option : type) {
            if (option.getText().trim().equals(customerTypeList)) {
                js.executeScript("arguments[0].click()",option);
                option.click();
                break;
            }
        }
    }


            WebElement comm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='commission']")));
            comm.clear();
            comm.sendKeys(commission);

            WebElement dbCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='dbLocation_code']")));
            dbCode.sendKeys(DBCode);

            WebElement dbName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='dbLocation_name']")));
            dbName.sendKeys(DBName);


            submit();

            driver.navigate().refresh();
           addCustomerButton();

        }
        driver.quit();
    }

    public void submit(){
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() ='Submit']")));

        js.executeScript("arguments[0].click()",submit);

    }

}
