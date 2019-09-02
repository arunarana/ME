package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewProjectPage extends BasePage
{
      @FindBy(name="customerId")private WebElement custDCrpDwn;
      @FindBy(name="name")private WebElement entrproj;
      @FindBy(name="createProjectSubmit")private WebElement createProjBtn;
      
      public CreateNewProjectPage(WebDriver driver)
      {
    	  super(driver);
    	  PageFactory.initElements(driver, this);
      }
      
      public void createProject(String customerName, String projectName)
      {
    	  Select sel = new Select(custDCrpDwn);
    	  sel.selectByVisibleText(customerName);
    	  entrproj.sendKeys(projectName);
    	  createProjBtn.click();
      }
}
