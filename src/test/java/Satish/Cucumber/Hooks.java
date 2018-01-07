package Satish.Cucumber;

import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks{
    public static WebDriver driver;
    public static String browser ="IE";
    
    @Before
   public void openBrowser() throws MalformedURLException {
	   
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
    	   System.out.println("Invalid browser parameter...");
       }
       System.out.println("Opening Browser...."+browser);
       driver.manage().deleteAllCookies();
       driver.manage().window().maximize();
	   }
        @After
        /**
         * Embed a screenshot in test report if test is marked as failed
         */
        public void embedScreenshot(Scenario scenario) {
            if(scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is: " + driver.getCurrentUrl());
               
//                byte[] screenshot = getScreenshotAs(OutputType.BYTES);
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
            }
            driver.quit();
        }
    }
    
     
   