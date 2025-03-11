package SearchPage;

import Excel.AreaXLSUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class AreaPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    private FluentWait<WebDriver> fluentWait;
    public AreaPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;


    }
    public void clickArea() {
        WebElement division = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Area']")));
        division.click();

    }

    public void addAreaButton() {

        WebElement addArea = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Area']")));
        //js.executeScript("arguments[0].click()",addDivision);
        addArea.click();


    }

    public void addInformation() throws IOException, InterruptedException {

        // Read Excel data
        String path = System.getProperty("user.dir");
        String filePath = path + "\\file\\Area.xls";
        List<String[]> testData = AreaXLSUtils.readExcelData(filePath);


        // Loop through each row

        for (String[] data : testData) {

            String code = data[0];
            String name = data[1];
            String remark = data[2];


            WebElement divisionCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='area_code']")));
            divisionCode.sendKeys(code);

            WebElement divisionName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='area_name']")));
            divisionName.sendKeys(name);

            WebElement remarks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='remarks']")));
            remarks.sendKeys(remark);


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
            addAreaButton();

        }
        driver.quit();
    }

    public void submit(){
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() ='Submit']")));
        submit.click();

    }

}
