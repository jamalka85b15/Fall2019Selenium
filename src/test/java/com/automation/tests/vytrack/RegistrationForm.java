package com.automation.tests.vytrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {

    private String URL = "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
//    private String firstNameLocator="firstname";
      private By firstNameBy= By.name("firstname");
//    private String lastNameLocator="lastname";
    private By lastNameBy= By.name("lastname");
    private By usernameBy=By.name("username");
    private By emailBy=By.name("email");
    private By password=By.name("password");
    private By phoneBy=By.name("phone");
    private By maleBy=By.cssSelector("input[value='male]");
    private By femaleBy=By.cssSelector("input[value='female]");
    private By otherBy=By.cssSelector("input[value='other]");
    private By dobBy=By.id("birthday");
    private By departmentBy=By.name("department");
    private By jobTitleBy =By.id("job-title");
    private By cplusplusBy=By.xpath("//lable[text()='C++']/preceding-sibling::input");
    private By javaBy=By.xpath("//lable[text()='Java']/preceding-sibling::input");
    private By javaScriptBy=By.xpath("//lable[text()='JavaScript']/preceding-sibling::input");
    private By signUpBy=By.id("wooden_spoon");


    @Test
    public void test1(){

    }



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
