package com.alefEducation.pageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

public class HomePage{

	/**
	 * @Description: This class is containing all required web objects with its required methods from Home Page.
	 * @author SATISH
	 * @Date: 09-Sept-2018
	 * @return 
	 */	
	   

	public HomePage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
		
	
	@FindBy(how=How.XPATH, using="//img[@src='/resources/images/pets.png']")
	public static WebElement petImageSrcAttribute;
	
	/**
	 * @Description: This method is useful to get image attributes.
	 * @author SATISH
	 * @Date: 09-Sept-2018
	 * @return String
	 */	
	public static String getImage()
	{
		String value = petImageSrcAttribute.getAttribute("src");
		Reporter.addStepLog("Fetching Image Attribute : "+value);;
		return value;
	}
	
	/**
	 * @Description: This method is useful to compare the actual and expected text values.
	 * @author SATISH
	 * @Date: 09-Sept-2018
	 * @return String
	 */	
	public static void validateValues(String expectedResult, String ActualResult)
	{
	assertEquals(expectedResult,ActualResult);	
	Reporter.addStepLog("Image Src Attribute is mathcing :  Actual : "+ActualResult+ " :: Expected :"+ expectedResult);	
	}
		
	}