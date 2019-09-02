package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generics.BaseLib;
import com.actitime.generics.EcelUtilities;
import com.actitime.pageobjects.ActiveProjAndCustPage;
import com.actitime.pageobjects.CreateNewCustPage;
import com.actitime.pageobjects.CreateNewProjectPage;
import com.actitime.pageobjects.CreateNewTaskPage;
import com.actitime.pageobjects.EditCustInfoPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.OpenTaskPage;
import com.actitime.pageobjects.ViewOpenTaskPage;

public class TasksTest extends BaseLib
{
        @Test
        public void createCustomer()
        {
        	String filePath="./testdata//testdata.xlsx";
        	String username = EcelUtilities .readData(filePath,"Sheet1", 3, 1);
        	String password = EcelUtilities .readData(filePath,"Sheet1", 3, 2);
        	LoginPage lp = new LoginPage(driver);
        	lp.login(username, password);
        	
        	EnterTimeTrackPage ettp = new EnterTimeTrackPage(driver);
        	ettp.clickOnTasks();
        	OpenTaskPage otp = new OpenTaskPage(driver);
        	otp.clickOnprojAndCustLink();
        	ActiveProjAndCustPage apcp = new ActiveProjAndCustPage(driver);
        	apcp.clickOnCreateNewCustBtn();
        	
        	String customerName = EcelUtilities.readData(filePath,"Sheet1", 3, 3);
        	CreateNewCustPage cncp =  new CreateNewCustPage(driver);
        	cncp.createCustomer(customerName);
        	
        	apcp.verifyCreateCustMsg(customerName);
        	
        	apcp.cliclOnLogout();
        }
        
      /* @Test(dependsOnMethods= {"createCustomer"})
        public void deleteCustomer()
     {
        	String filePath = "./testdata//testdata.xlsx";
        	String username = EcelUtilities.readData(filePath, "Sheet1", 4, 1);
        	String password = EcelUtilities.readData(filePath, "Sheet1", 4, 2);
        	LoginPage lp = new LoginPage(driver);
        	lp.login(username, password);
        	EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
        	ettp.clickOnTasks();
        	OpenTaskPage otp = new OpenTaskPage(driver);
        	otp.clickOnprojAndCustLink();
        	
        	String customerName = EcelUtilities.readData(filePath, "Sheet1", 4, 3);
        	ActiveProjAndCustPage apcp = new ActiveProjAndCustPage(driver);
        	apcp.showCustomer(customerName);
        	
        	EditCustInfoPage ecip = new EditCustInfoPage(driver);
        	ecip.deleteCustomer();
        	
        	apcp.verifyDelCustMsg();
        	apcp.cliclOnLogout();
        }*/
        
        @Test(dependsOnMethods= {"createCustomer"})
        public void createProject()
        {
        	
        	String filePath="./testdata//testdata.xlsx";
        	String username = EcelUtilities .readData(filePath,"Sheet1", 5, 1);
        	String password = EcelUtilities .readData(filePath,"Sheet1", 5, 2);
        	LoginPage lp = new LoginPage(driver);
        	lp.login(username, password);
        	
        	EnterTimeTrackPage ettp = new EnterTimeTrackPage(driver);
        	ettp.clickOnTasks();
        	OpenTaskPage otp = new OpenTaskPage(driver);
        	otp.clickOnprojAndCustLink();
        	ActiveProjAndCustPage apcp = new ActiveProjAndCustPage(driver);
        	apcp.clickOnCreateNewProjBtn();
        	
        	CreateNewProjectPage cnpp = new CreateNewProjectPage(driver);
        	 
        	String customerName = EcelUtilities.readData(filePath, "Sheet1", 5, 3);
        	String projectName = EcelUtilities.readData(filePath, "Sheet1", 5, 4);
        	cnpp.createProject(customerName, projectName);
        	
        	cnpp.cliclOnLogout();
        	
        }
        
       /* @Test(dependsOnMethods= {"createProject"})
        public void deleteProject()
        {
        	
        	String filePath="./testdata//testdata.xlsx";
        	String username = EcelUtilities .readData(filePath,"Sheet1", 5, 1);
        	String password = EcelUtilities .readData(filePath,"Sheet1", 5, 2);
        	LoginPage lp = new LoginPage(driver);
        	lp.login(username, password);
        	
        	EnterTimeTrackPage ettp = new EnterTimeTrackPage(driver);
        	ettp.clickOnTasks();
        	OpenTaskPage otp = new OpenTaskPage(driver);
        	otp.clickOnprojAndCustLink();
        	
        	String customerName = EcelUtilities.readData(filePath, "Sheet1", 6, 3);
        	ActiveProjAndCustPage apcp = new ActiveProjAndCustPage(driver);
        	apcp.showCustomer(customerName);
        	
        	String projectName = EcelUtilities.readData(filePath, "Sheet1", 6, 4);
        	apcp.deleteProj(projectName);
        	
        	apcp.cliclOnLogout();

        }*/
        
        @Test(dependsOnMethods= {"createProject"})
        public void createTask()
        {
        	String filePath="./testdata//testdata.xlsx";
        	String username = EcelUtilities .readData(filePath,"Sheet1", 5, 1);
        	String password = EcelUtilities .readData(filePath,"Sheet1", 5, 2);
        	LoginPage lp = new LoginPage(driver);
        	lp.login(username, password);
        	
        	EnterTimeTrackPage ettp = new EnterTimeTrackPage(driver);
        	ettp.clickOnTasks();
        	
        	OpenTaskPage otp = new OpenTaskPage(driver);
        	otp.clickCreateTask();
        	
        	String customerName = EcelUtilities.readData(filePath, "Sheet1",7 ,3 );
        	String projectName = EcelUtilities.readData(filePath, "Sheet1",7 ,4);
            String taskName = EcelUtilities.readData(filePath,"Sheet1", 7, 5);
        	CreateNewTaskPage cntp = new CreateNewTaskPage(driver);
        	cntp.createTask(customerName, projectName,taskName );
        	
        	otp.cliclOnLogout();
        	
        
        	otp.verifySuccessMsg();
        	
        }	
        
      /*  @Test(dependsOnMethods = {"createTask"})
        public void deleteTask()
        {
        	String filePath="./testdata//testdata.xlsx";
        	String username = EcelUtilities .readData(filePath,"Sheet1", 5, 1);
        	String password = EcelUtilities .readData(filePath,"Sheet1", 5, 2);
        	LoginPage lp = new LoginPage(driver);
        	lp.login(username, password);
        	
        	EnterTimeTrackPage ettp = new EnterTimeTrackPage(driver);
        	ettp.clickOnTasks();
        	
        	String custName = EcelUtilities.readData(filePath, "Sheet1",8 ,3 );
        	String projName = EcelUtilities.readData(filePath, "Sheet1", 8,4 );
        	String taskName = EcelUtilities.readData(filePath, "Sheet1",8 ,5 );
        	OpenTaskPage otp = new OpenTaskPage(driver);
        	otp.clickDeleteTaskLink(custName, projName, taskName);
        	
        	ViewOpenTaskPage votp = new ViewOpenTaskPage(driver);
        	votp.deleteTask();
        	
        }*/
        
}      

