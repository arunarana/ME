package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage extends BasePage
{
    private WebDriver driver;
	public EnterTimeTrackPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		
	}
	
	public void verifyHomePageTitle()
	{
		String actTitle = driver.getTitle();
		String expTitle = "actiTIME - Enter Time-Track";
		Assert.assertEquals(actTitle,expTitle );
		Reporter.log("Home page title is verified", true);
	}

}
