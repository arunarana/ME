package com.actitime.pageobjects;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewTaskPage 
{
     @FindBy(name="customerId")private WebElement selCustDrpDwn;
     @FindBy(name="projectId")private WebElement selProjDrDwn;
     @FindBy(xpath="//td[contains(@id,'cell')]/input[contains(@name,'name')]")private List<WebElement> enterTaskName;
     @FindBy(xpath="//input[contains(@id,'taskDeadline')]/following-sibling::img")private List<WebElement> enterDeadLine;
     @FindBy(xpath="//table[contains(@id,'ext-comp')]//td[@class='x-btn-center']")private WebElement clkMonthAndYear;
     @FindBy(xpath="//table[@id='ext-gen176']//tr/td")private List<WebElement> selMonthAndYear;
     @FindBy(xpath="//div[contains(@id,'bt')]/select [contains(@name,'billingType')]")private List<WebElement>bilTypeDrpDwn;
     @FindBy(xpath="//td[contains(@id,'cell')]/following-sibling::td/input[@type='checkbox']")private List<WebElement> selChkBx;
     @FindBy(xpath="//td[@class='formbuttonpane']/input[@value='Create Tasks']")private WebElement createTskBtn;
     
     
     public CreateNewTaskPage(WebDriver  driver) 
     {
    	 super();
    	 PageFactory.initElements(driver, this);
    	 
     }
    
     
     public void createTask(String customerName, String projectName, String taskName)
     {
    	 Select sel = new Select(selCustDrpDwn);
    	 sel.selectByVisibleText(customerName);
    	 sel = new Select(selProjDrDwn);
    	 sel.selectByVisibleText(projectName);
    	 for (int i = 0; i < enterTaskName.size(); i++)
    	{
    		 enterTaskName.get(i).sendKeys(taskName);
    		// Scanner scan = new Scanner(System.in);
    		 
    		// System.out.println("Enter Deadline in giver formate (e.g. Jul 24, 2018)");
    		 //String deadlineDate = scan.next();
    		 enterDeadLine.get(i).click();
    		 clkMonthAndYear.click();
    		 Scanner scan = new Scanner(System.in);
    		 System.out.println("enter month");
    		 String month = scan.next();
    		 for (int j = 0; j <selMonthAndYear.size() ; j++)
    		 {

        		 if(month.equalsIgnoreCase(selMonthAndYear.get(j).getText()))
        		 {
        			 selMonthAndYear.get(j).click();
        			 System.out.println("enter year");
        			 String year = scan.next();
        			 if(year.equalsIgnoreCase(selMonthAndYear.get(j).getText()))
        			 {
        				 selMonthAndYear.get(j).click();
        			 }
        		 }
		
    		 }
    		 WebElement bilDrpDwn = bilTypeDrpDwn.get(i);

    		 sel = new Select(bilDrpDwn);
    		 sel.selectByVisibleText("Billable");
    		 selChkBx.get(i).click();
    		 createTskBtn.click();
    		 break;
		}
     }
}

