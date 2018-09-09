Feature: PetClinic Spring Framework Automated Scenarios


Scenario: Verify image on home page
    When Nagivate to the PetClinic Application    
    Then Verify the pet image on home page 
   	Then Close the browser
    
Scenario Outline: Find all the Veterinarians which are added in the application
    When Nagivate to the PetClinic Application
    And Users click on Veterinarians Menu Link  
    Then Fetch all  the Veterinarians Names
    Then Validate one by one with expected data "<Name>" 
    Then Close the browser
        
    Examples:
    | Name   |
    | James Carter |
    | Rafael Ortega |
    | Henry Stevens |
    | Sharon Jenkins |
    | James Carter |
    | Helen Leary |
    
Scenario: Find all the existing owners which are added in application
    When Nagivate to the PetClinic Application
    And Users click on FindOwner Menu Link
    And User clicks on Find Owner button 
    Then Fetch all the existing owner Names are present in PetClinic application.  
    Then Close the browser
    
    
Scenario Outline: Add a new owner and add pet for that owner
    When Nagivate to the PetClinic Application
    And Users click on FindOwner Menu Link
    And User clicks on Add Owner button 
    Then User should navigate to add owner page  
   	And Users should be able to enter "<FirstName>", "<LastName>", "<Address>", "<City>", "<Telephone>"     
   	And User Clicks on Add New Pet button
  	Then User should be able to enter the "<PetName>", "<PetBirthDate>", "<PetType>"
  	  	Then Close the browser
  	  	
    Examples:
    | FirstName | LastName | Address	| 	City  | Telephone	| PetName		| PetBirthDate	|	PetType  |
    | Satish | Aware		| Pune India 	|	  Pune  | 9665856096 | Tiger		|	2001-01-01		|	Dog			 | 
    
     
Scenario Outline: Check all the information added for the newly created owner and pet is correct
    When Nagivate to the PetClinic Application
    And Users click on FindOwner Menu Link
    And User enters "<LastName>" and clicks on Find Owner button 
    And User clicks on  "<FirstName>", "<LastName>"   
    Then Check all the values are displayed correctly "<FirstName>", "<LastName>", "<Address>", "<City>", "<Telephone>", "<PetName>", "<PetBirthDate>", "<PetType>"
	  	Then Close the browser
	  	
    Examples:
    | FirstName | LastName | Address	| 	City  | Telephone	| PetName		| PetBirthDate	|	PetType  |
    | Satish | Aware		| Pune India 	|	  Pune  | 9665856096 | Tiger		|	2001-01-01		|	Dog			 |