package pages;

import io.appium.java_client.AppiumDriver;

public class WelcomPage extends PageBase {
    public AppiumDriver driver;

    public String experience="立即体验";
    public String city="厦门";
    public String tiaoguo="com.example.homeking.client:id/a2p";


    public WelcomPage(AppiumDriver driver) {
        this.driver = driver;
    }



}
