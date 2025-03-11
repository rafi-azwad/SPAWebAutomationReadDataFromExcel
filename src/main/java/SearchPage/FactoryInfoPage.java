package SearchPage;

import Excel.FactoryInfoCSVUtils;
import Excel.MarketSegmentXLSUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class FactoryInfoPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public FactoryInfoPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;


    }
    public void clickFactoryInfo() {
        WebElement factory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Factory Info']")));
        factory.click();

    }

    public void addFactoryInfo() {

        WebElement addFactory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Factory']")));
        //js.executeScript("arguments[0].click()",addDivision);
        addFactory.click();


    }

    public void addInformation() throws IOException, InterruptedException {

        // Read Excel data
        String path = System.getProperty("user.dir");
        String filePath = path + "\\file\\FACTORY_INFO.csv";
        List<String[]> testData = FactoryInfoCSVUtils.readCSVData(filePath);


        // Loop through each row

        for (String[] data : testData) {

            String code = data[0];
            String name = data[1];
            String address = data[2];


            WebElement factoryCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='factoryCode']")));
            factoryCode.sendKeys(code);

            WebElement factoryName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='factoryName']")));
            factoryName.sendKeys(name);

            WebElement address1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='address']")));
            address1.sendKeys(address);



            //Thread.sleep(2000);
            submit();


            //Thread.sleep(1000);
            driver.navigate().refresh();
            addFactoryInfo();

        }
        driver.quit();
    }

    public void submit(){
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() ='Submit']")));
        js.executeScript("arguments[0].click();", submit);

    }

}
