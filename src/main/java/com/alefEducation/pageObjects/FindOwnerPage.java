package com.alefEducation.pageObjects;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.cucumber.listener.Reporter;
/**
 * @Description: This class is containing all required web objects with its required methods from Find Owner Page..
 * @author SATISH
 * @Date: 09-Sept-2018
 * @return 
 */	
   
public class FindOwnerPage{
	 
	public FindOwnerPage(WebDriver driver)
	{
	    PageFactory.initElements(driver, this);
	   
	}

	@FindBy(how=How.XPATH, using="//span[contains(text(),'Find owners')]")
	public static WebElement findOwnersMenuLink;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Find') and @type='submit']")
	public static WebElement findOwnersSearchButton;

	@FindBys(@FindBy(how=How.XPATH, using="//table[@id='vets']//tr/td[1]/a"))
	public static List<WebElement> allOwnerNames;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Add Owner')]")
	public static WebElement addOwnerButton;
	
	
	@FindBy(how=How.XPATH, using="//button[@type='submit' and contains(text(),'Add Owner')]")
	public static WebElement submitOwnerDetailsButton;
	
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'New Pet')]")
	public static WebElement addNewPetButton;

	@FindBy(how=How.ID, using="firstName")
	public static WebElement firstNameInputBox;
	
	@FindBy(how=How.ID, using="lastName")
	public static WebElement lastNameInputBox;
	
	@FindBy(how=How.ID, using="address")
	public static WebElement addressInputBox;
	
	@FindBy(how=How.ID, using="city")
	public static WebElement cityInputBox;
	
	@FindBy(how=How.ID, using="telephone")
	public static WebElement telephoneInputBox;	
	
	@FindBy(how=How.ID, using="name")
	public static WebElement petNameInputBox;	
	
	@FindBy(how=How.ID, using="birthDate")
	public static WebElement birthDateInputBox;
	
	@FindBy(how=How.ID, using="type")
	public static WebElement petTypeDropDown;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Add Pet')]")
	public static WebElement addPetDropDown;
	
	@FindBy(how=How.XPATH, using="//td/a[contains(text(),'Satish Aware')]")
	public static WebElement clickOnSearchedOwner;
	
	
	@FindBy(how=How.XPATH, using="//th[contains(text(),'Name')]")
	public static WebElement ownerNameField;	
	@FindBy(how=How.XPATH, using="//th[contains(text(),'Name')]//following-sibling :: td/b")
	public static WebElement ownerNameValue;
	
	@FindBy(how=How.XPATH, using="//th[contains(text(),'Address')]")
	public static WebElement ownerAddressField;	
	@FindBy(how=How.XPATH, using="//th[contains(text(),'Address')]//following-sibling :: td")
	public static WebElement ownerAddressValue;
	
	@FindBy(how=How.XPATH, using="//th[contains(text(),'City')]")
	public static WebElement ownerCityField;	
	@FindBy(how=How.XPATH, using="//th[contains(text(),'City')]//following-sibling :: td")
	public static WebElement ownerCityValue;
	
	@FindBy(how=How.XPATH, using="//th[contains(text(),'Telephone')]")
	public static WebElement ownerTelephoneField;	
	@FindBy(how=How.XPATH, using="//th[contains(text(),'Telephone')]//following-sibling :: td")
	public static WebElement ownerTelephoneValue;
	
	
	@FindBy(how=How.XPATH, using="//dt[contains(text(),'Name')]")
	public static WebElement petNameField;	
	@FindBy(how=How.XPATH, using="//dt[contains(text(),'Name')]/following-sibling::dd")
	public static WebElement petNameFieldValue;
	
	@FindBy(how=How.XPATH, using="//dt[contains(text(),'Birth Date')]")
	public static WebElement petPetBirthDateField;	
	@FindBy(how=How.XPATH, using="//dt[contains(text(),'Birth Date')]/following-sibling::dd")
	public static WebElement  petPetBirthDateValue;
	
	@FindBy(how=How.XPATH, using="//dt[contains(text(),'Type')]")
	public static WebElement petTypeField;	
	@FindBy(how=How.XPATH, using="//dt[contains(text(),'Type')]/following-sibling::dd")
	public static WebElement  petTypeValue;
	
/****************************   Dynamic Web Elements  *******************************************/
	public static String ownerStringXpathValue="//td/a[contains(text(),'xxxxxxx')]";	
	
	/**
	 * @Description: This method is useful to replace value in string xpath at run time.
	 * @author SATISH
	 * @Date: 09-Sept-2018
	 * @return String
	 */
	public static String dynamicXpathReplace(String abc, String strXpath)
	{
		return strXpath.replace("xxxxxxx", abc);
	}
/**************************************************************************************************/
	/**
	 * @Description: This method is useful to create dynamic web element with real time value..
	 * @author SATISH
	 * @Date: 09-Sept-2018
	 * @return void
	 */
	public static void clickOnOwnerSearched(WebDriver driver, String strXpath, String OwnerName)
	{
		WebElement element = driver.findElement(By.xpath(dynamicXpathReplace(OwnerName,strXpath)));
		element.click();
		System.out.println("Clicking on :"+ element);
	}

/****************** WebElement Action Methods ********************************/
	/**
	 * @Description: This method is useful to click on any web element based on parameter.
	 * @author SATISH
	 * @Date: 09-Sept-2018
	 * @return void
	 */
	
	public static void clickOnWebElement(WebElement ele)
     {	
		if(!ele.isEnabled())
		{
			Reporter.addStepLog(ele + "is not enabled.");
		}
     	ele.click();
     	Reporter.addStepLog("Clicking on element : "+ele);
     }
	/**
	 * @Description: This method is useful to enter text in any web text box based on parameter.
	 * @author SATISH
	 * @Date: 09-Sept-2018
	 * @return void
	 */
	public static void enterTextInInputBox(String inputText, WebElement ele)
    {
		ele.sendKeys(inputText);;
    	Reporter.addStepLog("Entering input value text: "+ inputText+ "");
    }
	
	/**
	 * @Description: This method is useful to select any option for Pet Type drop own list based on input value.
	 * @author SATISH
	 * @Date: 09-Sept-2018
	 * @return void
	 */
	public static void selectDropdown(WebElement dropdown, String dropdownValue)
	{
		Select dropDownBox = new Select(dropdown);		
		dropDownBox.selectByVisibleText(dropdownValue);
		Reporter.addStepLog("Pet type option "+dropdownValue+" is selected.");
	}
	
	/**
	 * @Description: This method is useful to get all the Owner Names are from Application.
	 * @author SATISH
	 * @Date: 09-Sept-2018
	 * @return Set<String>
	 */
	public static Set<String> getAllOwnersNames()
	{
		HashSet<String> allNames = new HashSet<String>();	
		for(WebElement a: allOwnerNames)
		{
			allNames.add(a.getText());
		}
		Reporter.addStepLog("All existing owners which are added on application are : "+ allNames);
		return allNames;
	}
	/**
	 * @Description: This method is useful to check the Owner Names is present or not.
	 * @author SATISH
	 * @Date: 09-Sept-2018
	 * @return boolean
	 */
	public static boolean checkOwnerNameIsDisplayed(String name, Set<String> allName)
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
	/**
	 * @Description: This method is useful to validate the Owner and its pet information.
	 * @author SATISH
	 * @Date: 09-Sept-2018
	 * @return boolean
	 */
public static boolean validateOwnerPetInformation(Hashtable<String, String> expectedData)
	{
		Hashtable<String, String> actualOwnerValues = new Hashtable<String, String>();
		actualOwnerValues.put(ownerNameField.getText(), ownerNameValue.getText());
		actualOwnerValues.put(ownerAddressField.getText(), ownerAddressValue.getText());
		actualOwnerValues.put(ownerCityField.getText(), ownerCityValue.getText());
		actualOwnerValues.put(ownerTelephoneField.getText(), ownerTelephoneValue.getText());
		actualOwnerValues.put("PetName" , petNameFieldValue.getText());
		actualOwnerValues.put(petPetBirthDateField.getText(),petPetBirthDateValue.getText());
		actualOwnerValues.put(petTypeField.getText(), petTypeValue.getText());		
		if (expectedData.equals(actualOwnerValues))
			Reporter.addStepLog("All Data Matched. \n Expected Data = "+expectedData+ "\n Actual Data = "+actualOwnerValues);
		else
			Reporter.addStepLog("Information about owner or pet is not matching. \n Expected Data = "+expectedData+ "\n Actual Data = "+actualOwnerValues);
		
		return true;
	}	


}
