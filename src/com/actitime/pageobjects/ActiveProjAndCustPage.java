package com.actitime.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class ActiveProjAndCustPage extends BasePage
{
     @FindBy (css="input[value='Create New Customer']")private WebElement createNewCustBtn;
     @FindBy(className="successmsg")private WebElement successMsg;//create cust delet cust variable is common
     @FindBy(name="selectedCustomer")private WebElement customereDrpDwn;
     @FindBy(css="input[value*='Show']")private WebElement showBtn;
     @FindBy(xpath="//td[starts-with(@id,'customerNameCell')]//a[contains(@href,'customerId')]")private List<WebElement> custNameLink; //revist dis xpath imp
     @FindBy(css="input[value='Create New Project']")private WebElement createNewProjBtn;   
     @FindBy(css="td[class='selectProject']")private List<WebElement> selectProjToDel;
     @FindBy(xpath="//input[@value='Delete Selected']") private WebElement deleteProj;
     public ActiveProjAndCustPage(WebDriver driver)
     {
    	 super(driver);//while extending basepage
    	 PageFactory.initElements(driver, this);
     }
     
     public void clickOnCreateNewCustBtn()
     {
    	 createNewCustBtn.click();
     }
     
     public void verifyCreateCustMsg(String customerName)
     {
    	String actMsg =  successMsg.getText();
   	    Assert.assertTrue(successMsg.isDisplayed());
   	    Assert.assertTrue(actMsg.contains(customerName));
   	    Reporter.log(actMsg, true);
   	  
     }
     
     public void showCustomer(String customerName)
     {
    	 Select sel = new Select(customereDrpDwn);
    	 sel.selectByVisibleText(customerName);
    	 showBtn.click();
    	 if (custNameLink.get(0).getText().equals(customerName))
    	 {
			custNameLink.get(0).click();
		 }
    	 else
    	 {
    		System.out.println(customerName+"customer not exist"); 
    	 }
    }
     
     public void verifyDelCustMsg()
     {
    	 String expMsg = "Customer has been successfully deleted.";
    	 String actMsg = successMsg.getText();
    	 Assert.assertEquals(expMsg, actMsg);
    	 Reporter.log(expMsg, true);
     }
     
     public void clickOnCreateNewProjBtn()
    
     {
    	 createNewProjBtn.click();
     }

     public void verifyCreateProjMsg(String projectName)
     {
    	String actMsg =  successMsg.getText();
   	    Assert.assertTrue(successMsg.isDisplayed());
   	    Assert.assertTrue(actMsg.contains(projectName));
   	    Reporter.log(actMsg, true);
   	  
     }
     
     public void deleteProj(String projectName)
     {
    	 for (int i = 0; i <selectProjToDel.size(); i++)
    	 {
			
		
    	 if (selectProjToDel.get(i).getText().equals(projectName))
    	 {
			custNameLink.get(i).click();
		 }
    	 else
    	 {
    		System.out.println(projectName+"project not exist"); 
    	 }
    	 deleteProj.click();
    	 }
     }
    
     public void verifyDelProjMsg()
     {
    	 String expMsg = "Selected projects have been successfully deleted.";
    	 String actMsg = successMsg.getText();
    	 Assert.assertEquals(expMsg, actMsg);
    	 Reporter.log(expMsg, true);
     }
}
