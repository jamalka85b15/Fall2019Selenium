package com.automation.tests.day5;

import com.automation.tests.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtilities.wait(2);
        List<WebElement> radioButtons=driver.findElements(By.tagName("input"));
        for(WebElement radioButton:radioButtons){

            String id=radioButton.getAttribute("id");

          if(radioButton.isEnabled()){
             radioButton.click();
            System.out.println("Clicked on :: "+id);
            BrowserUtilities.wait(1);

        }else{
              System.out.println("Disabled :: "+ id);
          }

    }
        driver.quit();
}}