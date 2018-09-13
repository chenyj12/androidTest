package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotListener extends TestListenerAdapter {
    public AppiumDriver driver;

    public ScreenshotListener(AppiumDriver driver) {
        this.driver = driver;
    }
    public void onTestFailure(ITestResult tr){
        File location=new File("result/screenshots");
        String screenShotName=location.getAbsolutePath()+File.separator+tr.getMethod().getMethodName()+getNowDate()+".png";
        File screenShot=driver.getScreenshotAs(OutputType.FILE);
        try{
            org.apache.commons.io.FileUtils.copyFile(screenShot, new File(screenShotName));
                      }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    private String getNowDate() {
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String currentTime=sdf.format(d);
        return currentTime;
    }
}
