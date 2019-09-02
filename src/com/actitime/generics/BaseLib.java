package com.actitime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib 
{
       public WebDriver driver;//baselib driver sld be in public
       @BeforeMethod
       @Parameters({"browser","testurl"})
       public void setUp(String browserName, String url)
       {
    	 if(browserName.equalsIgnoreCase("firefox")) 
    	 {
    		 System.setProperty("webdriver.gecko.driver","./exefiles/geckodriver.exe");
    		 driver = new FirefoxDriver();
    		 Reporter.log("firefox launched", true);
    	 }
    	 else if(browserName.equalsIgnoreCase("chrome")) 
    	 {
    		 System.setProperty("webdriver.chrome.driver","./exefiles/chromedriver.exe");
    		 driver = new ChromeDriver();
    		// driver = new RemoteWebDriver(DesiredCapabilities.chrome());
    		 Reporter.log("chrome launched", true);
    	 }
    	 else if(browserName.equalsIgnoreCase("edge")) 
    	 {
    		 System.setProperty("webdriver.edge.driver","./exefiles/MicrosoftWebDriver.exe");
    		 driver = new  EdgeDriver();
    		 Reporter.log("Edge launched, true");
    	 }
    	 driver.manage().window().maximize();
    	// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	 WaitStatementLib.iWaitForSecs(driver,20);
    	 driver.get(url);
    	 Reporter.log(url+"url navigated", true);
    	 
       }
       @AfterMethod
       public void tearDown(ITestResult result)
       {
    	  String scriptName = result.getMethod().getMethodName();
    	  
		if(result.isSuccess())//true--->pass
    	  {
    		  Reporter.log(scriptName+"script is passed",true);
          }
    	  else 
    	  {
    		  ScreenShotLib slib = new ScreenShotLib();
    		  slib.takeScreenshot(driver, scriptName);
    		  Reporter.log("screenshot has been taken", true);
    		  
    	  }
    	  driver.close();
    	  Reporter.log("browser closed", true);
       }
}
