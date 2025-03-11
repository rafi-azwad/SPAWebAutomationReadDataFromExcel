package SearchPage;

import Excel.CategoryInfoXLSUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class CategoryInfoPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public CategoryInfoPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;


    }
    public void clickCategoryInfo() {
        WebElement category = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Category Info']")));
        category.click();

    }

    public void addCategoryButton() {

        WebElement addCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Category']")));
        //js.executeScript("arguments[0].click()",addDivision);
        addCategory.click();


    }

    public void addInformation() throws IOException, InterruptedException {

        // Read Excel data
        String path = System.getProperty("user.dir");
        String filePath = path + "\\file\\CATEGORY_INFO.xls";
        List<String[]> testData = CategoryInfoXLSUtils.readExcelData(filePath);


        // Loop through each row

        for (String[] data : testData) {

            String code = data[0];
            String name = data[1];
            String remark = data[2];
            String bName = data[3];

            WebElement territoryCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='categoryCode']")));
            territoryCode.sendKeys(code);

            WebElement territoryName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='categoryName']")));
            territoryName.sendKeys(name);

    /*        WebElement brandDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Brand Name']//following::input[1]")));
            js.executeScript("arguments[0].click()",brandDropDown);

     *//*     Select select = new Select(driver.findElement(By.xpath("//label[text()='Brand Name']")));
            select.selectByValue(""+bName+"");*//*

            WebElement brandName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@value,'"+bName+"')]")));
            //brandName.click();
            js.executeScript("arguments[0].click()",brandName);*/


            WebElement dropdown = driver.findElement(By.xpath("//label[text()='Brand Name']//following::input"));
            dropdown.click();
            //Thread.sleep(2000);

            // Click dropdown to open options
// Wait for the dropdown options to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li")));

// Select an option by text
            String desiredOption = bName; // Change this to the required value
            for (WebElement option : options) {
                if (option.getText().equals(desiredOption)) {
                    option.click();
                    break;
                }
            }


            WebElement remarks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='remarks']")));
            remarks.sendKeys(remark);



            //Thread.sleep(2000);
            submit();

            //Thread.sleep(1000);
            driver.navigate().refresh();
            addCategoryButton();

        }
        driver.quit();
    }

    public void submit(){
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() ='Submit']")));
        submit.click();

    }

}
