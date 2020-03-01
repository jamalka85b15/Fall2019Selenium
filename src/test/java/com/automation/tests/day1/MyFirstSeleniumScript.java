package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {
        //setup chromeDriver
        WebDriverManager.chromedriver().setup();
        //create chromdriver object
        ChromeDriver driver=new ChromeDriver();
        //open some website
        driver.get("http://google.com");


    }
}
