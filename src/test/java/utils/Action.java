package utils;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Action extends TestSuit  {
    public AppiumDriver driver;

    public Action(AndroidDriver androidDriver) {
        this.driver=androidDriver;
    }


    /**
     * 点击方法
     *
     * @param by
     */
    public void click(By by) {
        try {
            sleep(1000);
            driver.findElement(by).click();
        } catch (Exception e) {
            sleep(2000);
            driver.findElement(by).click();
        }

    }

    /**
     * 输入某个值
     * @param by
     * @param string
     */
    public  void input(By by,String string){
        try {
            sleep(1000);
            driver.findElement(by).sendKeys(string);
        }catch (Exception e){
            System.out.println(by+"无法输入，用例执行失败");
        }

    }

    /**
     * 某个元素滑动到某个元素
     *
     * @param startElement
     * @param endElement
     * @param Up
     */
    public void swipe(By startElement, By endElement, boolean Up) {
        Point beginLoc;
        WebElement start = driver.findElement(startElement);
        beginLoc = start.getLocation();
        WebElement end;
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MICROSECONDS);
        while (true) {
            try {
                end = driver.findElement(endElement);
                break;
            } catch (Exception e) {
                if (Up) {
                    driver.swipe(beginLoc.getX(), beginLoc.getY(), beginLoc.getX() + 30, beginLoc.getY() + 90, 4000);
                } else {
                    driver.swipe(beginLoc.getX(), beginLoc.getY(), beginLoc.getX() - 30, beginLoc.getY() - 90, 4000);

                }

            }

        }
    }

    /**
     * 向左滑动
     * @param during  滑动时间
     *
     */

    public void swipToLeft(int during) {
        int width=driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width * 9 / 10, height / 2, width / 10, height / 2, during);
        sleep(2000);
    }

    /**
     *
     * @param during
     * 位置的百分比，2-10， 例如3就是 从2/3滑到1/3
     */
    public void swipToDown(int during){
        int width=driver.manage().window().getSize().width;
        int height=driver.manage().window().getSize().height;
        driver.swipe(width / 2, height / 3, width / 2, height * 2/3, during);
    }

    /**
     * 往某个方向滑动
     * @param direction
     */
    public void swip(String direction){
        switch (direction){
            case "DOWN":
                swipToDown(1000);
                break;
            case  "LEFT":
                swipToLeft(1000);
                break;
        }
    }

    /**
     * 在某个方向滑动直到这个元素出现
     *
     * @param by        控件
     */
    public boolean swipUtilElement(By by) {
        boolean flag=true;
        while(flag) {
            try {
                driver.findElement(by).isDisplayed();
            } catch (Exception e) {
                swipToDown(1000);
            }
            break;
        }

        return flag;

    }


    /**
     * 休眠
     *
     * @param time
     */

    public void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断某个元素控件是否存在，如果存在就返回true,不存在就抛出失败
     *
     * @param by
     * @return
     */
    public boolean isElementExist(By by) {
        boolean isDisplayed = false;
        try {
            isDisplayed = driver.findElement(by).isDisplayed();

        } catch (Exception e) {
            isDisplayed = false;
            System.out.println(by+"控件不存在");
        }
        return isDisplayed;

    }

}
