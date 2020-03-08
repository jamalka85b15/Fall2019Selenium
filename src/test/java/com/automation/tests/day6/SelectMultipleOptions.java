package com.automation.tests.day6;

import com.automation.tests.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectMultipleOptions {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtilities.wait(3);
        Select languagesSelect=new Select(driver.findElement(By.name("Languages")));

        boolean isMultiuple=languagesSelect.isMultiple();
        System.out.println(isMultiuple);



        BrowserUtilities.wait(3);
        driver.quit();
    }

}
