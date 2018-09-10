package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.IndexPage;
import pages.LoginPage;
import pages.WelcomPage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class TestSuit {
     public AppiumDriver driver;
     public LoginPage loginPage;
     public IndexPage indexPage;
     public WelcomPage welcomPage;



    @BeforeSuite
    public void AndroidSettings() throws MalformedURLException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "2.9.4.apk");
        if (!app.exists()) {
            System.out.println("已存在");
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","127.0.0.1:62001");
        capabilities.setCapability("platformVersion", "5.1");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.example.homeking.client");
        capabilities.setCapability("appActivity", "com.example.homeking.client.controllers.intro.IntroActivity");
        capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("resetKeyboard", "True");

        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        loginPage=new LoginPage(driver);
        indexPage= new IndexPage(driver);
        welcomPage=new WelcomPage(driver);


    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
