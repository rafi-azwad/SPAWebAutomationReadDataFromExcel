package SearchPage;

import Excel.DivisionXLSUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class DivisionPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;


    private FluentWait<WebDriver> fluentWait;

    public DivisionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;

    }


private WebElement fluentWait(WebElement locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }




        public void login(){
            WebElement userId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='employeeId']")));
            userId.sendKeys("123456");

            WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
            password.sendKeys("12345");

            WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Login']")));
            login.click();
        }


    public void clickMISandSetup() {
        WebElement mis = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'MIS')]")));
        mis.click();

        WebElement setup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Setup']")));
        setup.click();
    }
    public void clickDivision() {

        WebElement division = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Division']")));
        division.click();

    }

    public void addDivisionButton()  {

        WebElement addDivision = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Division']")));
        //js.executeScript("arguments[0].click()",addDivision);
        addDivision.click();

    }

    public void addInformation() throws IOException, InterruptedException {

        // Read Excel data
        String path = System.getProperty("user.dir");
        String filePath = path + "\\file\\DIVISION.xls";
        List<String[]> testData = DivisionXLSUtils.readExcelData(filePath);


        // Loop through each row

            for (String[] data : testData) {

                String code = data[0];
                String name = data[1];


                WebElement divisionCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='division_code']")));
                divisionCode.sendKeys(code);

                WebElement divisionName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='division_name']")));
                divisionName.sendKeys(name);



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
                addDivisionButton();

            }
        driver.quit();
        }

    public void submit(){
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() ='Submit']")));
        submit.click();

    }

}
