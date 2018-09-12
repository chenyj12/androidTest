package cases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestSuit;


public class TestLogin extends TestSuit {


    @Test(priority = 1)
    public void testIstall() {
        au.sleep(1000);
        System.out.println("result:"+driver.isAppInstalled("com.example.homeking.client"));
        Assert.assertEquals(driver.isAppInstalled("com.example.homeking.client"), true, "安装失败");
    }

    @Test(priority = 2)
    public void weclome(){
        au.swipToLeft(1000);
        au.swipToLeft(1000);
        au.click(By.name(welcomPage.experience));
        au.click(By.name(welcomPage.city));
        Assert.assertEquals(au.isElementExist(By.name(welcomPage.city)), true);

    }
    @Test(priority = 3)
    public void logoin(){
        au.click(By.name(loginPage.me));
        if (au.isElementExist(By.name(loginPage.userblance))){
            au.swipe(By.name(loginPage.userblance),By.name(loginPage.setting),true);
            au.click(By.name(loginPage.setting));
            au.click(By.name(loginPage.logout));
            au.click(By.name(loginPage.confirm));
            au.sleep(1000);
        }
        au.click(By.name(loginPage.passwardlogin));
        au.input(By.id(loginPage.phone),"15060785807");
        au.input(By.id(loginPage.password),"12345600");
        au.click(By.name(loginPage.login));
        Assert.assertEquals(au.isElementExist(By.name(loginPage.userblance)),true);

    }

}
