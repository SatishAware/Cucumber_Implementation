package com.alefEducation.stepDefinations;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks{
    public static WebDriver driver;
    public static String browser ="Chrome";
    
	/**
	 * @Description: This method is useful to launch the browser based on the browser value.
	 * @author SATISH
	 * @Date: 09-Sept-2018
	 * @return void
	 */
    
    
    @Before
   public void openBrowser() {
	   
	   if(browser.equals("Chrome"))
       {
    	   System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//drivers//chromedriver.exe");
           driver = new ChromeDriver();
       }
       else if(browser.equals("Firefox"))
       {
    	   System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//test//resources//drivers//geckodriver.exe");
           driver = new FirefoxDriver(); 
       }
       else if(browser.equals("IE"))
       {
    	   System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"//src//test//resources//drivers//IEDriverServer.exe");
           driver = new InternetExplorerDriver();   
       }
       else {
    	   Reporter.addStepLog("Invalid browser parameter...");
       }
	   //Reporter.addStepLog(browser + "Browser is launching: ");
       driver.manage().deleteAllCookies();
       driver.manage().window().maximize();
	   }
	/**
	 * @Description: This method is useful take screen shot.
	 * @author SATISH
	 * @Date: 09-Sept-2018
	 * @return void
	 */        
    @After
        public void takeScreenshot(Scenario scenario) {
            if(scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is: " + driver.getCurrentUrl());

                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            	Reporter.addStepLog(somePlatformsDontSupportScreenshots.getMessage());
            }
            }
            driver.quit();
            Reporter.addStepLog("Closing all browser instances.");
        }
       
	/**
	 * @Description: This method is useful to clean the session.
	 * @author SATISH
	 * @Date: 09-Sept-2018
	 * @return void
	 */
       /* @After
        public void closeBrowser()
        {
        	Reporter.addStepLog("Closing all browser instances.");
        	driver.quit();
        }*/
        
       
    }
    
     
   