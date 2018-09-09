package com.alefEducation.stepDefinations;

import static org.testng.Assert.assertEquals;

import java.util.HashSet;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;

import com.alefEducation.pageObjects.FindOwnerPage;
import com.alefEducation.pageObjects.HomePage;
import com.alefEducation.pageObjects.VeterinariansPage;
import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * @Description: This class is containing all the step definitions to test the feature scenarios.
 * @author SATISH
 * @Date: 09-Sept-2018
 * @return 
 */	
public class Alef_StepDefinations
{
	public static WebDriver driver;	    
	public Alef_StepDefinations()
		{
			driver= Hooks.driver;		
			new HomePage(driver);
			 new VeterinariansPage(driver);
			 new FindOwnerPage(driver);
		}    

@When("^Nagivate to the PetClinic Application$")
public void nagivate_to_the_PetClinic_Application() throws Throwable {
	driver.get("http://localhost:8080/");	
	Reporter.addStepLog("Navigating to Pet Clinic Application URL http://localhost:8080/ ");
  
}

@Then("^Verify the pet image on home page$")
public void verify_the_pet_image_on_home_page() throws Throwable {
   String actualImgAttr = HomePage.getImage();
   String expectedImgAttr="http://localhost:8080/resources/images/pets.png";
   HomePage.validateValues(expectedImgAttr, actualImgAttr);
}    
 
@When("^Users click on Veterinarians Menu Link$")
public void users_click_on_Veterinarians_Menu_Link() throws Throwable {
	VeterinariansPage.clickOnVeterinariansMenu();
}

@Then("^Fetch all  the Veterinarians Names$")
public void fetch_all_the_Veterinarians_Names() throws Throwable
{
    
	VeterinariansPage.getAllVeterinariansNames();
}

@Then("^Validate one by one with expected data \"(.*?)\"$")
public void validate_one_by_one_with_expected_data(String arg1) throws Throwable
{
   String expectedName = arg1;
   HashSet<String> actualNames = (HashSet<String>) VeterinariansPage.getAllVeterinariansNames();
   VeterinariansPage.checkVeterinariansNameIsDisplayed(expectedName,actualNames);
}

@When("^Users click on FindOwner Menu Link$")
public void users_click_on_FindOwner_Menu_Link() throws Throwable {
	FindOwnerPage.clickOnWebElement(FindOwnerPage.findOwnersMenuLink);
}

@When("^User clicks on Find Owner button$")
public void user_clicks_on_Find_Owner_button() throws Throwable {
	FindOwnerPage.clickOnWebElement(FindOwnerPage.findOwnersSearchButton);
}

@Then("^Fetch all the existing owner Names are present in PetClinic application\\.$")
public void fetch_all_the_existing_owner_Names_are_present_in_PetClinic_application() throws Throwable {
	FindOwnerPage.getAllOwnersNames();
}
    

/**************Add Owner and Pet scenario stepDefs **********/

@When("^User clicks on Add Owner button$")
public void user_clicks_on_Add_Owner_button() throws Throwable {
	FindOwnerPage.clickOnWebElement(FindOwnerPage.addOwnerButton);
}

@Then("^User should navigate to add owner page$")
public void user_should_navigate_to_add_owner_page() throws Throwable {
   //Here we can check the URL or page headers.
	
	assertEquals("PetClinic :: a Spring Framework demonstration",driver.getTitle());
	assertEquals("http://localhost:8080/owners/new",driver.getCurrentUrl()); 
	
}

@Then("^Users should be able to enter \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\"$")
public void users_should_be_able_to_enter(String arg1, String arg2, String arg3, String arg4,String arg5) throws Throwable {
  
	FindOwnerPage.enterTextInInputBox(arg1, FindOwnerPage.firstNameInputBox);
	FindOwnerPage.enterTextInInputBox(arg2, FindOwnerPage.lastNameInputBox);
	FindOwnerPage.enterTextInInputBox(arg3, FindOwnerPage.addressInputBox);
	FindOwnerPage.enterTextInInputBox(arg4, FindOwnerPage.cityInputBox);
	FindOwnerPage.enterTextInInputBox(arg5, FindOwnerPage.telephoneInputBox);
	
	FindOwnerPage.clickOnWebElement(FindOwnerPage.submitOwnerDetailsButton);
	
}

@Then("^User Clicks on Add New Pet button$")
public void user_Clicks_on_Add_New_Pet_button() throws Throwable {
	FindOwnerPage.clickOnWebElement(FindOwnerPage.addNewPetButton);
}

@Then("^User should be able to enter the \"(.*?)\", \"(.*?)\", \"(.*?)\"$")
public void user_should_be_able_to_enter_the(String arg1, String arg2, String arg3) throws Throwable {
	FindOwnerPage.enterTextInInputBox(arg1, FindOwnerPage.petNameInputBox);
	FindOwnerPage.enterTextInInputBox(arg2, FindOwnerPage.birthDateInputBox);
	FindOwnerPage.selectDropdown(FindOwnerPage.petTypeDropDown, arg3.toLowerCase());
	
	FindOwnerPage.clickOnWebElement(FindOwnerPage.addPetDropDown);
	
}

/**************Check the all information about specific Owner *************/

@When("^User enters \"(.*?)\" and clicks on Find Owner button$")
public void user_enters_and_clicks_on_Find_Owner_button(String arg1) throws Throwable {
	FindOwnerPage.enterTextInInputBox(arg1, FindOwnerPage.lastNameInputBox);
	
	FindOwnerPage.clickOnWebElement(FindOwnerPage.findOwnersSearchButton);
}

@When("^User clicks on  \"(.*?)\", \"(.*?)\"$")
public void user_clicks_on(String arg1, String arg2) throws Throwable {
	FindOwnerPage.clickOnOwnerSearched(driver, FindOwnerPage.ownerStringXpathValue, arg1+" "+arg2);
}

@Then("^Check all the values are displayed correctly \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\"$")
public void check_all_the_values_are_displayed_correctly(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) throws Throwable {
	Hashtable<String, String> expectedValues = new Hashtable<String, String>();
	expectedValues.put("Name", arg1+" "+arg2);
	expectedValues.put("Address", arg3);
	expectedValues.put("City", arg4);
	expectedValues.put("Telephone", arg5);
	expectedValues.put("PetName", arg6);
	expectedValues.put("Birth Date", arg7);
	expectedValues.put("Type", arg8.toLowerCase());	
	
	FindOwnerPage.validateOwnerPetInformation(expectedValues);
	
}

@Then("^Close the browser$")
public void close_the_Browser() throws Throwable {
	Reporter.addStepLog("Closing all browser instances.");
	driver.quit();
}

}