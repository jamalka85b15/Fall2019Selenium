package com.automation.tests.officehours;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOH2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationpractice.com");
        WebElement searchBox=driver.findElement(By.id("search_query_top"));
        searchBox.sendKeys("tshirt"+ Keys.ENTER);
        WebElement error=driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
        BrowserUtils.wait(2);
        String errorText =error.getText();
        System.out.println("Error message "+ errorText);

        searchBox=driver.findElement(By.id("search_query_top"));
        searchBox.clear();
        searchBox.sendKeys("t-shirt"+ Keys.ENTER);
        BrowserUtils.wait(2);
        WebElement count=driver.findElement(By.className("product-count"));
        System.out.println("itemcount "+ count.getText());

        WebElement addToCart= driver.findElement(By.className("button ajax_add_to_cart_button btn btn-default"));
        addToCart.click();



        driver.quit();
    }
}
