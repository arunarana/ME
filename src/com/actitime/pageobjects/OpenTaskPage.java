package com.actitime.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class OpenTaskPage extends BasePage
{
	
      @FindBy(linkText="Projects & Customers")private WebElement projAndCustLink;
      @FindBy(css="input[value='Create New Tasks']")private WebElement createTask;
      @FindBy(className="successmsg")private WebElement successMsg;
      @FindBy(xpath="//td[contains(@id,'taskName')]/a[contains(@href,'/tasks/task_details')]")private WebElement clkTaskLink;
      @FindBy(xpath="//td[contains(@id,'taskNameCell')]/preceding-sibling::td")private List<WebElement> custAndProj;
       
       
      public OpenTaskPage(WebDriver driver)
      {
    	 super(driver);
    	 PageFactory.initElements(driver,this); 
      }
      
      public void clickOnprojAndCustLink()
      {
    	  projAndCustLink.click();
      }
      
      public void clickCreateTask()
      {
    	  createTask.click();
      }
      
      public void verifySuccessMsg() 
      {
    	  String actMsg =  successMsg.getText();
     	    Assert.assertTrue(successMsg.isDisplayed());
     	    Assert.assertTrue(actMsg.contains("1 new task was added to"));
     	    Reporter.log(actMsg, true);  
      }
     
      public void clickDeleteTaskLink(String custName, String projName, String taskName)
      {
    	  if(custName.equalsIgnoreCase(custAndProj.get(0).getText()) && projName.equalsIgnoreCase(custAndProj.get(1).getText()) && taskName.equalsIgnoreCase(clkTaskLink.getText()) )
    	  {  
    		  
    	     clkTaskLink.click();
    	  }
      }
      }
