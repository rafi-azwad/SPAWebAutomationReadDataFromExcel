package SearchPage;

import Excel.TerritoryXLSUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class TerritoryPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public TerritoryPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;


    }
    public void clickTerritory() {
        WebElement territory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Territory']")));
        territory.click();

    }

    public void addTerritoryButton() {

        WebElement addTerritory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Territory']")));
        //js.executeScript("arguments[0].click()",addDivision);
        addTerritory.click();


    }

    public void addInformation() throws IOException, InterruptedException {

        // Read Excel data
        String path = System.getProperty("user.dir");
        String filePath = path + "\\file\\TERRITORY_INFO.xls";
        List<String[]> testData = TerritoryXLSUtils.readExcelData(filePath);


        // Loop through each row

        for (String[] data : testData) {

            String code = data[0];
            String name = data[1];
            String address1 = data[2];
            String remark = data[3];


            WebElement territoryCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='territory_code']")));
            territoryCode.sendKeys(code);

            WebElement territoryName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='territory_name']")));
            territoryName.sendKeys(name);

            WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='address']")));
            address.sendKeys(address1);

            WebElement remarks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='remarks']")));
            remarks.sendKeys(remark);

            submit();

            driver.navigate().refresh();
            addTerritoryButton();

        }
        driver.quit();
    }

    public void submit(){
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() ='Submit']")));
        submit.click();

    }

}
