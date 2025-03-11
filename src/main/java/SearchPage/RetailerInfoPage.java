package SearchPage;


import Excel.RetailerInfoXLSXUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class RetailerInfoPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public RetailerInfoPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;


    }


    public void clickRetailerInfo() {
        WebElement info = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Retailer Info']")));
        info.click();

    }

    public void addRetailerInfo() {

        WebElement addRetailer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Retailer']")));
        //js.executeScript("arguments[0].click()",addDivision);
        addRetailer.click();


    }

    public void addInformation() throws IOException, InterruptedException {

        // Read Excel data
        String path = System.getProperty("user.dir");
        String filePath = path + "\\file\\RetailerInfo.xlsx";
        List<String[]> testData = RetailerInfoXLSXUtils.readXLSXData(filePath);


        // Loop through each row

        for (String[] data : testData) {

            String code = data[0];
            String name = data[1];
            String address = data[2];
            String contactPerson = data[3];
            String contactNumber = data[4];
            String retailerType = data[5];
            String retailerCategory = data[6];
            String retailerLocation = data[7];
            String specialDiscount = data[8];
            String monthlyAvgSales = data[9];



            WebElement retailerId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='retailerId']")));
            retailerId.sendKeys(code);

            WebElement retailerName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='retailerNameEn']")));
            retailerName.sendKeys(name);

            WebElement retailerAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='addressEn']")));
            retailerAddress.sendKeys(address);

            WebElement retailerContactPerson = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='contactPerson']")));
            retailerContactPerson.sendKeys(contactPerson);

            WebElement retailerContactNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='contactNumber']")));
            retailerContactNumber.sendKeys(contactNumber);


            WebElement recommendedByTSO = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Recommend By TSO*']//following::div[1]")));
            js.executeScript("arguments[0].click()",recommendedByTSO);
            recommendedByTSO.click();

            // Click dropdown to open options

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> tso = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//ul[@role='listbox']//li")));

// Select an option by text
            String tsoList = "Recommend";
            for (WebElement option : tso) {
                if (option.getText().trim().equalsIgnoreCase(tsoList)) {
                    js.executeScript("arguments[0].click()",option);
                    option.click();
                    break;
                }
            }

            WebElement approvedByASM = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Approved By ASM*']//following::div[1]")));
            js.executeScript("arguments[0].click()",approvedByASM);
            approvedByASM.click();

            // Click dropdown to open options

            List<WebElement> asm = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//ul[@role='listbox']//li")));

// Select an option by text
            String asmList = "Recommend";
            for (WebElement option : asm) {
                if (option.getText().trim().equalsIgnoreCase(asmList)) {
                    js.executeScript("arguments[0].click()",option);
                    option.click();
                    break;
                }
            }


            WebElement retailerType1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Retailer Type*']//following::div[1]")));
            js.executeScript("arguments[0].click()",retailerType1);
            retailerType1.click();

            // Click dropdown to open options

            List<WebElement> type = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//ul[@role='listbox']//li")));
                   // By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li")));



            if(retailerType.equalsIgnoreCase("R")) {
// Select an option by text
                String typeList = "Retail";
                for (WebElement option : type) {
                    if (option.getText().trim().equalsIgnoreCase(typeList)) {
                        js.executeScript("arguments[0].click()", option);
                        option.click();
                        break;
                    }
                }

            }


            else if(retailerType.equalsIgnoreCase("W")) {
// Select an option by text
                String typeList = "Wholesales";
                for (WebElement option : type) {
                    if (option.getText().trim().equalsIgnoreCase(typeList)) {
                        js.executeScript("arguments[0].click()", option);
                        option.click();
                        break;
                    }
                }

            }

            else if(retailerType.equalsIgnoreCase("B")) {
// Select an option by text
                String typeList = "Both";
                for (WebElement option : type) {
                    if (option.getText().trim().equalsIgnoreCase(typeList)) {
                        js.executeScript("arguments[0].click()", option);
                        option.click();
                        break;
                    }
                }
            }
    else if(retailerType.equalsIgnoreCase("M" ) || retailerType.equalsIgnoreCase( "Mini Super Shop")) {

// Select an option by text
                String typeList = "Mini Super Shop";
                for (WebElement option : type) {
                    if (option.getText().trim().equalsIgnoreCase(typeList)) {
                        js.executeScript("arguments[0].click()", option);
                        option.click();
                        break;
                    }
                }

            } //end of retailer type


      /*      WebElement retailerCategory1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Retailer Category*']//following::div[1]")));
            js.executeScript("arguments[0].scrollIntoView(true);", retailerCategory1);
            js.executeScript("arguments[0].click()",retailerCategory1);
            retailerCategory1.click();
            Thread.sleep(500);
            retailerCategory1.click()*/;

            WebElement retailerCategory1 = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//label[text()='Retailer Category*']//following::div[1]")));

// Ensure element is visible and ready
            js.executeScript("arguments[0].scrollIntoView(true);", retailerCategory1);
            wait.until(ExpectedConditions.elementToBeClickable(retailerCategory1));

// Try clicking using JavaScript
            js.executeScript("arguments[0].click();", retailerCategory1);




            // Click dropdown to open options
            List<WebElement> category = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
            //By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li")));
            By.xpath("//ul[@role='listbox']//li")));

            if(retailerCategory.equalsIgnoreCase("G")) {
// Select an option by text
                String categoryList = "Grocery";
                for (WebElement option : category) {
                    option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li[text()='" + categoryList + "']")));
                    if (option.getText().trim().equals(categoryList)) {
                        //option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li[text()='" + categoryList + "']")));
                        option.click();
                        break;
                    }
                }

            }


            else if(retailerCategory.equalsIgnoreCase("GS")) {
// Select an option by text
                String categoryList = "General Store";
                for ( WebElement option : category) {
                    option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li[text()='" + categoryList + "']")));
                    if (option.getText().trim().equals(categoryList)) {
                        option.click();
                        break;
                    }
                }

            }
    else if(retailerCategory.equalsIgnoreCase("MS")) {

// Select an option by text
                String categoryList = "Mini Super Shop";
                for (WebElement option : category) {
                    option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li[text()='" + categoryList + "']")));
                    if (option.getText().trim().equals(categoryList)) {
                        /*wait.until(ExpectedConditions.elementToBeClickable(option)).click();
                        //js.executeScript("arguments[0].click()", option);
                        //option.click();*/
                        //option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li[text()='" + categoryList + "']")));
                        option.click();
                        break;
                    }
                }

            }
    else if(retailerCategory.equalsIgnoreCase("T")) {

// Select an option by text
                String categoryList = "T-Shop";
                for (WebElement option : category) {
                    option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li[text()='" + categoryList + "']")));
                    if (option.getText().trim().equals(categoryList)) {
                       // option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li[text()='" + categoryList + "']")));
                        option.click();
                        break;
                    }
                }

            }

    else if(retailerCategory.equalsIgnoreCase("O")) {

// Select an option by text
                String categoryList = "Others";
                for (WebElement option : category) {
                    option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li[text()='" + categoryList + "']")));
                    if (option.getText().trim().equals(categoryList)) {
                        //option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li[text()='" + categoryList + "']")));
                        option.click();
                        break;
                    }
                }

            }
    else if(retailerCategory.equalsIgnoreCase("D")) {

// Select an option by text
                String categoryList = "Departmantal Store";
                for (WebElement option : category) {
                    option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li[text()='" + categoryList + "']")));
                    if (option.getText().trim().equals(categoryList)) {
                        //option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li[text()='" + categoryList + "']")));
                        option.click();
                        break;
                    }
                }

            }
    else if(retailerCategory.equalsIgnoreCase("S")) {

// Select an option by text
                String categoryList = "Stationary";
                for (WebElement option : category) {
                    option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li[text()='" + categoryList + "']")));
                    if (option.getText().trim().equals(categoryList)) {
                        //option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li[text()='" + categoryList + "']")));
                        option.click();
                        break;
                    }
                }

            }

    else if(retailerCategory.equalsIgnoreCase("B")) {

// Select an option by text
                String categoryList = "Beauty Parlour";
                for (WebElement option : category) {
                    option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li[text()='" + categoryList + "']")));
                    if (option.getText().trim().equals(categoryList)) {
                        //option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li[text()='" + categoryList + "']")));
                        option.click();
                        break;
                    }
                }

            } //end of retailer category

            WebElement sDiscount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Special Discount*']//following::div[1]")));
            js.executeScript("arguments[0].scrollIntoView(true);", sDiscount);
            js.executeScript("arguments[0].click();", sDiscount);
            sDiscount.click();

           /* Actions actions = new Actions(driver);
            actions.moveToElement(sDiscount).click().perform();*/

            // Click dropdown to open options

            List<WebElement> discount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//ul[@role='listbox']//li")));
            // By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li")));



            if(specialDiscount.equalsIgnoreCase("Y")) {

// Select an option by text
                String discountList = "Yes";
                for (WebElement option : discount) {
                    // option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']//li[text()='" + discountList + "']")));

                    if (option.getText().trim().equals(discountList)) {
                        js.executeScript("arguments[0].click()", option);
                        option.click();
                        break;
                    }
                }

            }


            else if(specialDiscount.equalsIgnoreCase("N")) {

// Select an option by text
                String discountList = "No";
                for (WebElement option : discount) {

                    //option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']//li[text()='" + discountList + "']")));


                    if (option.getText().trim().equals(discountList)) {
                        js.executeScript("arguments[0].click()", option);

                        option.click();
                        break;
                    }
                }

            } //end of special discount


            WebElement retailerLocation1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Retailer Location*']//following::div[1]")));
            js.executeScript("arguments[0].click();", retailerLocation1);
            retailerLocation1.click();

    /*js.executeScript("arguments[0].scrollIntoView(true);", retailerLocation1);
            wait.until(ExpectedConditions.elementToBeClickable(retailerLocation1));

// Try clicking using JavaScript
            js.executeScript("arguments[0].click();", retailerLocation1);*/


            // Click dropdown to open options

            List<WebElement> location = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                   By.xpath("//ul[@role='listbox']//li")));
            //By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li")));



            if(retailerLocation.equalsIgnoreCase("U") || retailerLocation.equalsIgnoreCase("Urban/Metro")) {
// Select an option by text
                String locationList = "Urban or Metro";
                for (WebElement option : location) {
                    if (option.getText().trim().equalsIgnoreCase(locationList)) {
                        js.executeScript("arguments[0].click()", option);
                        option.click();

                        break;
                    }
                }

            }

            else if(retailerLocation.equalsIgnoreCase("R")) {
// Select an option by text
                String locationList = "Rular";
                for (WebElement option : location) {
                    if (option.getText().trim().equalsIgnoreCase(locationList)) {
                        js.executeScript("arguments[0].click()", option);
                        option.click();

                        break;
                    }
                }

            }


            else if(retailerLocation.equalsIgnoreCase("SU")) {
// Select an option by text
                String locationList = "Semi-Urban";
                for (WebElement option : location) {
                    if (option.getText().trim().equalsIgnoreCase(locationList)) {
                        js.executeScript("arguments[0].click()", option);
                        option.click();
                        break;
                    }
                }

            } //end of retailer location



            WebElement monthlyAvg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='monthlyAvgSales']")));
           /* monthlyAvg.clear();
            monthlyAvg.sendKeys(monthlyAvgSales);*/

            js.executeScript("arguments[0].value='';", monthlyAvg); // Clear the field
            js.executeScript("arguments[0].value=arguments[1];", monthlyAvg, monthlyAvgSales);

            submit();

            //Thread.sleep(1000);
            driver.navigate().refresh();
            addRetailerInfo();

        }
        driver.quit();
    }

    public void submit(){
        WebElement submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Submit']")));
        js.executeScript("arguments[0].click();", submit);

    }

}
