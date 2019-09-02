package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generics.BaseLib;
import com.actitime.generics.EcelUtilities;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;

public class LoginTest extends BaseLib
{
   @Test(priority=1)
   public void validLoginTest()
   {

  
	   String filepath="./testdata/testdata.xlsx";//testHarness
	   String username = EcelUtilities.readData(filepath,"Sheet1", 1, 1);
	   String password = EcelUtilities.readData(filepath,"Sheet1", 1, 2);
	   
	   LoginPage lp= new LoginPage(driver);
	   lp.login(username, password);
	   EnterTimeTrackPage ettp = new EnterTimeTrackPage(driver);
	   ettp.verifyLogo();
	   ettp.verifyHomePageTitle();
	   
	 }
   @Test(priority=2)
   public void invalidLoginTest() 
   {
	   String filepath="./testdata/testdata.xlsx";
	   String username = EcelUtilities.readData(filepath,"Sheet1", 2, 1);
	   String password = EcelUtilities.readData(filepath,"Sheet1", 2, 2);
	   
	   LoginPage lp= new LoginPage(driver);
	   lp.login(username, password); 
	   lp.verifyInvalidLoginMsg();
   }
   }