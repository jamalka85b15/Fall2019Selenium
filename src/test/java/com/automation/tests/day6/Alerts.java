package com.automation.tests.day6;

import com.automation.tests.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtilities.wait(3);
        List<WebElement> buttons=driver.findElements(By.tagName("button"));
        buttons.get(0).click();
        BrowserUtilities.wait(3);

        driver.switchTo().alert().accept();



        BrowserUtilities.wait(3);
        driver.quit();
    }
}
