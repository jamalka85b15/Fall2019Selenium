package com.automation.tests.day6;

import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtilities.wait(3);
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));

        Select selectSimpleDropdown = new Select(simpleDropdown);
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtilities.wait(3);
        selectSimpleDropdown.selectByVisibleText("Option 1");

        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectDay.selectByVisibleText("1");
        selectMonth.selectByVisibleText("February");
        selectYear.selectByVisibleText("2003");

        BrowserUtilities.wait(3);
        List<WebElement> months=selectMonth.getOptions();
        for(WebElement month: months){
            String monthName=month.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtilities.wait(1);
        }
        BrowserUtilities.wait(3);
        Select stateSelect=new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("District of Columbia");

        String selected = stateSelect.getFirstSelectedOption().getText();

        if(selected.equals("District of Columbia")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        List<WebElement> states =stateSelect.getOptions();
        for (WebElement stateOption: states){
            System.out.println(stateOption.getText());
        }
        BrowserUtilities.wait(3);
    driver.quit();

    }
}
