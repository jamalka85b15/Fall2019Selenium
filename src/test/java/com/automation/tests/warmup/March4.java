package com.automation.tests.warmup;

import com.automation.utilities.WebDriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class March4 {
    static WebDriver driver;

    public static void main(String[] args) throws Exception {
ebayTest();
amazonTest();
wikiTest();





    }
    public static void ebayTest() {
        driver= WebDriverFactory.createADriver("chrome");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResult =driver.findElement(By.tagName("h1"));
        System.out.println(searchResult.getText().split(" ")[0]);
        driver.quit();


    }
    public static void amazonTest() throws Exception{
        driver = WebDriverFactory.createADriver("chrome");
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);
        String title=driver.getTitle();
        Thread.sleep(2000);
        if(title.contains("java book")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }
        driver.quit();
    }

    public static void wikiTest() throws Exception{
        driver= WebDriverFactory.createADriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        driver.findElement(By.id("searchInput")).sendKeys("Selenium webdriver", Keys.ENTER);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        Thread.sleep(2000);

        String link=driver.getCurrentUrl();

                if(link.endsWith("Selenium_(software)")){
                    System.out.println("TEST PASSED");
                }else{
                    System.out.println("TEST FAILED");
                }
                driver.quit();
    }
}
