@qa @prod @int @ext_agency @dev
Feature: Create & Verify Station 

Scenario: Verify Pagination on Search Station Page
	Given user is on Search Station Page
	Then verify Pagination is present on the Search Station Page
	When user click on Next button on Pagination on the Search Station Page
	Then user is navigated to next Search Station Result
	
Scenario: Verify export to excel on Search Station Page.
	Given user is on Search Station Page
	When user click on Export to excel link on Search Station Page
	Then excel report is saved on local machine for search station
	Then verify the station count in excel
	
Scenario: Search ,Create & Edit Station with New Data
	Given user is on Search Station Page
    Given user enters new Data on Search Station Page
    | Field Name   |  Value   |
    | Full Name    | Testing  |
    | Short Name   | Te       |
    When user clicks on search button on Search Station Page
    Then user will not find the required Station on Search Station Page
 
    When user will click on Create Station
    When user will fill all mandatory fields
    | Field Name   |  Value   |
    | Full Name    | Testing  |
    | Short Name   | Te       |
    | Station Type | National |
    | Region       | US       |
    | Zone         | Pacific  |
        
    When user will save data
    Then user will get success message
    Then user will click on dubbing details and fill fields
    | Field Name   					     |  Value   |
    | Air Content Format - SD (Longform) | Data DVD |
    | Tape Quantity 				     | 1        |
    | Air Content Format - SD (Shortform)| Data DVD |
    | Longform length 				     | 28       |
    Then user will click on contact tab
    Then user will click on Add contact button and fill all mandatory fields on pop up
    | Field Name   |  Value        |  					     
    | Name         | XYZ           |
    | Contact Type | TRAFFIC (AIR) |
    | Address      | Data DVD      |
    Then user will click on Agency Permissions tab.
    Then user will click on move all button and save.
    
        
Scenario: Test Warning Messages
   
   Given user is on Search Station Page
   When user will click on Create Station
   When user will save data
   Then user will get warning message
   

    
   
