package Core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.IOException;

import static Core.BrowserHelper.driver;

public class ScreenShotUtil {
    public static <Stirng> void getScreenshot(Stirng methodName) {

        try {
            Thread.sleep(2000);
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir") + "/src/screenshots/";
            FileUtils.copyFile(scrFile, new File(currentDir + methodName + System.currentTimeMillis() + ".png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Thread.sleep(3000);
    }


//not working
    public static void takeScreenshot(String fileName) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir") + "/src/screenshots/";
            FileUtils.copyFile(scrFile, new File(currentDir + fileName + System.currentTimeMillis() + ".png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterTest
    public static void successfulScreenshot(ITestResult result) {
        System.out.println("successful login ++++++++++");

        if (ITestResult.SUCCESS == result.getStatus()) {
            takeScreenshot(result.getMethod().getMethodName());
        }

    }
    @AfterTest
    public static void failScreenshot(ITestResult result){
        System.out.println("failed to login ++++++++++");

        if (ITestResult.FAILURE == result.getStatus()){
            takeScreenshot(result.getMethod().getMethodName());
        }

    }

}
