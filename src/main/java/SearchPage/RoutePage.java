package SearchPage;

import Excel.RouteXLSUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class RoutePage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public RoutePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;


    }
    public void clickRoute() {
        WebElement route = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Route']")));
        route.click();

    }

    public void addRouteButton() {

        WebElement addRoute = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Route']")));
        //js.executeScript("arguments[0].click()",addRoute);
        addRoute.click();


    }

    public void addInformation() throws IOException, InterruptedException {

        // Read Excel data
        String path = System.getProperty("user.dir");
        String filePath = path + "\\file\\Route_Data.xls";
        List<String[]> testData = RouteXLSUtils.readExcelData(filePath);


        // Loop through each row

        for (String[] data : testData) {

            String code = data[0];
            String name = data[1];
            String address1 = data[2];
            String remark = data[3];


            WebElement territoryCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='route_code']")));
            territoryCode.sendKeys(code);

            WebElement territoryName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='route_name']")));
            territoryName.sendKeys(name);

            WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='address']")));
            address.sendKeys(address1);

            WebElement remarks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='remarks']")));
            remarks.sendKeys(remark);


            //Thread.sleep(2000);
            submit();
       /*     try {
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
            addRouteButton();

        }
        driver.quit();
    }

    public void submit(){
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() ='Submit']")));
        submit.click();

    }

}


