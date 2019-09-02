package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustInfoPage 
{
      @FindBy(css="input[value='Delete This Customer']")private WebElement delThisCustBtn;
      @FindBy(id="deleteButton")private WebElement delConfirmBtn;
      
      public EditCustInfoPage(WebDriver driver)
      {
    	  PageFactory.initElements(driver,this);
      }
      
      public void deleteCustomer()
      {
    	  delThisCustBtn.click();
    	  delConfirmBtn.click();
      }
}
