package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class CalendarEventPage extends AbstractPageBase {

     public CalendarEventPage(){
     PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css="[title='Create Calendarevent']")
    public WebElement createCalendarEvent;


}
