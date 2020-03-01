package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;

public class BasicNavigation {
    public static void main(String[] args) throws Exception {
        //to start selenium script we need:
        //setup webdriver (browser driver )and create webdriver object

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(3000); //for demo wait 3 seconds


        String title=driver.getTitle();//will return title <title>Some title <title/>
        String expectedTitle="Google";
        System.out.println("Title is"+title);
        if (expectedTitle.equals(title)){
            System.out.println("Test is Passed");
        }else{
            System.out.println("Failed");
        }
       driver.close();//to close browser
    }
}
