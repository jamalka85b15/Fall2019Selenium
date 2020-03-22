package com.automation.tests.day6;

import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtilities.wait(3);
        Select statesSelect=new Select(driver.findElement(By.id("state")));

        statesSelect.selectByValue("DC");

        String expected="District Of Columbia";
        String actual=statesSelect.getFirstSelectedOption().getText();
        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }
        BrowserUtilities.wait(2);
        driver.quit();

    }
}
