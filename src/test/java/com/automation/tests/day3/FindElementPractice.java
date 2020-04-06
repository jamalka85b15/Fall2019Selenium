package com.automation.tests.day3;

import com.automation.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementPractice {
    public static void main(String[] args) throws Exception{
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver =new ChromeDriver();
        WebDriver driver= WebDriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullName=driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mister Twister");
        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys("sdet@cybertek.com");

        WebElement signUp=driver.findElement(By.name("wooden_spoon"));
        signUp.click();

        //signUp.submit();
        Thread.sleep(2000);
        String expected="Thank you for signing up. Click the button below to return to the home page.";
        WebElement message=driver.findElement(By.className("subheader"));
        String actual=message.getText();
        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        driver.quit();
    }
}
