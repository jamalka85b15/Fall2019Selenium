package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectDropdown {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        driver.findElement(By.id("dropdownMenuLink")).click();
        BrowserUtils.wait(2);

//        driver.findElement(By.linkText("Google")).click();
        List<WebElement> allLinks=driver.findElements(By.className("dropdown-item"));
        for(WebElement link: allLinks){
            System.out.println(link.getText()+ " : "+ link.getAttribute("href"));
        }

        BrowserUtils.wait(2);
        driver.quit();
    }


}
