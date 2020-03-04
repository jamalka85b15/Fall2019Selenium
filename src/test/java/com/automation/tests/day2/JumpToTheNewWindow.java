package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);
        //every window has some id, this is calls window handle
        //based on wiondow hale we can switch in between windows
        String windowHandle =driver.getWindowHandle();
        System.out.println("windowHandle = " + windowHandle);
        Set<String> windowHandles=driver.getWindowHandles();
        System.out.println(windowHandles);
        System.out.println("Before switch "+ driver.getCurrentUrl());
        //since we know all windows
        //we can say switch to something that is not equals to old id

        for(String windowId: windowHandles){
            if(!windowId.equals(windowHandle)){
                driver.switchTo().window(windowId);
            }

        }
        System.out.println("After switch "+ driver.getCurrentUrl());
        driver.close();
    }
    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for(String window: windows){
            driver.switchTo().window(window);

        }
    }
}
