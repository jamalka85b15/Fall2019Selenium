package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    /*
    This method return webDriver object based on browser type
    If you want to use chrome browser, just provide chrome as parameter
    @param browserName
    @return webdriver object
     */
    public static WebDriver createADriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    }
}
