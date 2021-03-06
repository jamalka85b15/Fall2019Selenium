package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);
        WebElement blackbutton=driver.findElement(By.id("black"));
        if(blackbutton.isDisplayed() && blackbutton.isEnabled()){
            System.out.println("CLICKED ON BLACK BUTTON");
            blackbutton.click();
        }else{
            System.out.println("FAILED CLICK ON BALCK BUTTON");
        }
        if(blackbutton.isSelected()){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }
    }
}
