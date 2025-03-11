package SearchPage;

import Excel.MarketSegmentXLSUtils;
import Excel.MarketXLSUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class MarketPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public MarketPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;


    }
    public void clickMarket() {
        WebElement market = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Market']")));
        market.click();

    }

    public void addMarket() {

        WebElement addMarket = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Market']")));
        //js.executeScript("arguments[0].click()",addDivision);
        addMarket.click();


    }

    public void addInformation() throws IOException, InterruptedException {

        // Read Excel data
        String path = System.getProperty("user.dir");
        String filePath = path + "\\file\\MARKET_INFO.xls";
        List<String[]> testData = MarketXLSUtils.readXLSXData(filePath);


        // Loop through each row

        for (String[] data : testData) {

            String code = data[0];
            String name = data[1];
            String address = data[2];
            String marketSegmentCode = data[3];



            WebElement marketCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='market_code']")));
            marketCode.sendKeys(code);

            WebElement marketName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='market_name']")));
            marketName.sendKeys(name);

            WebElement address1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='address']")));
            address1.sendKeys(address);

            if(marketSegmentCode.trim().equals("1001")) {

                WebElement segmentName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='//label[text()='Market Segment Code*']//following::div[1]")));
                js.executeScript("arguments[0].scrollIntoView(true);", segmentName);
                js.executeScript("arguments[0].click();", segmentName);
                segmentName.click();

                List<WebElement> segment = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//ul[@role='listbox']//li")));
                // By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li")));


// Select an option by text
                    String segmentList = "Radhuni";
                    for (WebElement option : segment) {
                        // option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']//li[text()='" + discountList + "']")));

                        if (option.getText().trim().equals(segmentList)) {
                            js.executeScript("arguments[0].click()", option);
                            option.click();
                            break;
                        }

            }
            }

  else if(marketSegmentCode.trim().equals("1002")) {

                WebElement segmentName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='//label[text()='Market Segment Code*']//following::div[1]")));
                js.executeScript("arguments[0].scrollIntoView(true);", segmentName);
                js.executeScript("arguments[0].click();", segmentName);
                segmentName.click();

                List<WebElement> segment = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//ul[@role='listbox']//li")));
                // By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li")));


// Select an option by text
                    String segmentList = "Ruchi";
                    for (WebElement option : segment) {
                        // option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']//li[text()='" + discountList + "']")));

                        if (option.getText().trim().equals(segmentList)) {
                            js.executeScript("arguments[0].click()", option);
                            option.click();
                            break;
                        }

            }
            }


  else if(marketSegmentCode.trim().equals("1003")) {

                WebElement segmentName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='//label[text()='Market Segment Code*']//following::div[1]")));
                js.executeScript("arguments[0].scrollIntoView(true);", segmentName);
                js.executeScript("arguments[0].click();", segmentName);
                segmentName.click();

                List<WebElement> segment = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//ul[@role='listbox']//li")));
                // By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li")));


// Select an option by text
                    String segmentList = "Combine";
                    for (WebElement option : segment) {
                        // option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']//li[text()='" + discountList + "']")));

                        if (option.getText().trim().equals(segmentList)) {
                            js.executeScript("arguments[0].click()", option);
                            option.click();
                            break;
                        }

            }
            }


  else if(marketSegmentCode.trim().equals("1004")) {

                WebElement segmentName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='//label[text()='Market Segment Code*']//following::div[1]")));
                js.executeScript("arguments[0].scrollIntoView(true);", segmentName);
                js.executeScript("arguments[0].click();", segmentName);
                segmentName.click();

                List<WebElement> segment = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//ul[@role='listbox']//li")));
                // By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li")));


// Select an option by text
                    String segmentList = "Jita";
                    for (WebElement option : segment) {
                        // option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']//li[text()='" + discountList + "']")));

                        if (option.getText().trim().equals(segmentList)) {
                            js.executeScript("arguments[0].click()", option);
                            option.click();
                            break;
                        }

            }
            }


  else if(marketSegmentCode.trim().equals("1005")) {

                WebElement segmentName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='//label[text()='Market Segment Code*']//following::div[1]")));
                js.executeScript("arguments[0].scrollIntoView(true);", segmentName);
                js.executeScript("arguments[0].click();", segmentName);
                segmentName.click();

                List<WebElement> segment = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//ul[@role='listbox']//li")));
                // By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li")));


// Select an option by text
                    String segmentList = "House Sales";
                    for (WebElement option : segment) {
                        // option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']//li[text()='" + discountList + "']")));

                        if (option.getText().trim().equals(segmentList)) {
                            js.executeScript("arguments[0].click()", option);
                            option.click();
                            break;
                        }

            }
            }


  else if(marketSegmentCode.trim().equals("1006")) {

                WebElement segmentName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='//label[text()='Market Segment Code*']//following::div[1]")));
                js.executeScript("arguments[0].scrollIntoView(true);", segmentName);
                js.executeScript("arguments[0].click();", segmentName);
                segmentName.click();

                List<WebElement> segment = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//ul[@role='listbox']//li")));
                // By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li")));


// Select an option by text
                    String segmentList = "Test";
                    for (WebElement option : segment) {
                        // option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']//li[text()='" + discountList + "']")));

                        if (option.getText().trim().equals(segmentList)) {
                            js.executeScript("arguments[0].click()", option);
                            option.click();
                            break;
                        }

            }
            }



            //Thread.sleep(2000);
            submit();


            //Thread.sleep(1000);
            driver.navigate().refresh();
            addMarket();

        }
        driver.quit();
    }

    public void submit(){
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() ='Submit']")));
        js.executeScript("arguments[0].click();", submit);

    }

}
