package com.alefEducation.pageObjects;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;
/**
 * @Description: This class is containing all required web objects with its required methods from Veterinarians Page.
 * @author SATISH
 * @Date: 09-Sept-2018
 * @return 
 */	
   
public class VeterinariansPage {
	
	public VeterinariansPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
}
	

@FindBy(how=How.XPATH, using="//span[contains(text(),'Veterinarians')]")
public static WebElement veterinariansMenuLink;

@FindBys(@FindBy(how=How.XPATH, using="//table[@id='vets']//tr/td[1]"))
public static List<WebElement> veterinariansNames;



/**
 * @Description: This method is useful to click on the Veterinarians menu.
 * @author SATISH
 * @Date: 09-Sept-2018
 * @return void
 */
public static void clickOnVeterinariansMenu()
{
	veterinariansMenuLink.click();
	Reporter.addStepLog("Clicking on veterinarians Menu Link.");
}
/**
 * @Description: This method is useful to get all the Veterinarians Names
 * @author SATISH
 * @Date: 09-Sept-2018
 * @return void
 */
public static Set<String> getAllVeterinariansNames()
{
	HashSet<String> allNames = new HashSet<String>();	
	for(WebElement a: veterinariansNames)
	{
		allNames.add(a.getText());
	}	
	Reporter.addStepLog("All veterinarians names displayed on Veterinarians Page are : "+ allNames);
	return allNames;
}
/**
 * @Description: This method is useful to check the name is populated or not.
 * @author SATISH
 * @Date: 09-Sept-2018
 * @return boolean
 */
public static boolean checkVeterinariansNameIsDisplayed(String name, Set<String> allName)
{
	if(allName.contains(name))
	{
		Reporter.addStepLog(name +"is displayed on Veterinarians Page.");
		
		return true;
	}
	else
	{
		Reporter.addStepLog(name +"is not displayed on Veterinarians Page.");
		return false;
	}
	
}

}
