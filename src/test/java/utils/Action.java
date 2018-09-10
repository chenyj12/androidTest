package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Action {
    public AppiumDriver driver;

    /**
     * 点击方法
     * @param by
     */
    public void click(By by){
        try {
            driver.findElement(by).click();
        }catch (Exception e){
           sleep(2000);
            driver.findElement(by).click();
        }

    }

    /**
     * 滑动方法
     * @param startElement
     * @param endElement
     * @param Up
     */
    public void swipe(By startElement,By endElement,boolean Up){
        Point beginLoc;
        WebElement start=driver.findElement(startElement);
        beginLoc =start.getLocation();
        WebElement end;
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MICROSECONDS);
        while (true){
            try {
                end=driver.findElement(endElement);
                break;
            }catch (Exception e){
                if (Up){
                    driver.swipe(beginLoc.getX(), beginLoc.getY(), beginLoc.getX()+30, beginLoc.getY()+90, 4000);
                }else {
                    driver.swipe(beginLoc.getX(), beginLoc.getY(), beginLoc.getX()-30, beginLoc.getY()-90, 4000);

                }

            }

        }

    }

    public void sleep(long time){
        try {
            Thread.sleep(time);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
