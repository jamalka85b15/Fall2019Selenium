package com.automation.tests.day6;

import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMultipleOptions {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtilities.wait(3);
        Select languagesSelect=new Select(driver.findElement(By.name("Languages")));

        boolean isMultiuple=languagesSelect.isMultiple();
        System.out.println(isMultiuple);

        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("Python");
        languagesSelect.selectByVisibleText("JavaScript");

        List<WebElement> selectedLanguages=languagesSelect.getAllSelectedOptions();
        for(WebElement selectedLanguage: selectedLanguages){
            System.out.println(selectedLanguage.getText());

        }
        BrowserUtilities.wait(3);
        languagesSelect.deselectByVisibleText("Java");
      languagesSelect.deselectAll();




        BrowserUtilities.wait(3);
        driver.quit();
    }

}
