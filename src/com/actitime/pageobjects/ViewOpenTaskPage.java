package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewOpenTaskPage
{
      @FindBy(css="input[value='Delete This Task']")private WebElement deleteTaskBtn;
      @FindBy(id="deleteButton")private WebElement confirmDelTask;
      
      public ViewOpenTaskPage(WebDriver driver)
      {
    	  PageFactory.initElements(driver, this);
      }
      
      public void deleteTask()
      {
    	  deleteTaskBtn.click();
    	  confirmDelTask.click();
      }
}
