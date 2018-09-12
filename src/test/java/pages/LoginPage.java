package pages;

import io.appium.java_client.AppiumDriver;

public class LoginPage {

    public AppiumDriver driver;
    public String me="我的";
    public  String login="登录";
    public String passwardlogin="密码登录";
    public String userblance="余额";
    public String setting="设置";
    public String logout="退出当前账号";
    public String confirm="确定";
    public String phone="com.example.homeking.client:id/g9";
    public String password="com.example.homeking.client:id/g8";


    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }


}
