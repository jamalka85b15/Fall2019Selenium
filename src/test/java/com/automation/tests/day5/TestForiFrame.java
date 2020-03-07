package com.automation.tests.day5;

import com.automation.tests.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForiFrame {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtilities.wait(4);
        WebElement textInput =driver.findElement(By.id("tinymce"));
        System.out.println(textInput.getText());
        BrowserUtilities.wait(4);

        textInput.click();
        textInput.sendKeys("Hello world");

        BrowserUtilities.wait(4);

        driver.switchTo().defaultContent();

        WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());

        driver.quit();
    }
}
