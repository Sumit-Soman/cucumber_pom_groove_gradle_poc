@qa @prod @dev @int

Feature: Test Validation, Pagination, Export to Excel, Searching and Creating on Creative Page and open a creative to verify all tabs
Scenario: Verify Pagination on Search Creative Page
	Given user is on Search Creative Page
	Then verify Pagination is present on the Search Creative Page
	When user click on Next button on Pagination
	Then user is navigated to next Search Creative Result
	
Scenario: Verify export to excel on Search Creative Page.
	Given user is on Search Creative Page
	When user click on Export to excel link on Search Creative Page
	Then excel report is saved on local machine
	Then verify the Creative count in excel

Scenario: Search for existing creative with MediaType, Product, Show, Region and Version
	Given user is on Search Creative Page
	Given user enters media type, product, show, region and Version on Search Creative Page 
	| Field Names |   value           |
	| Media Type  | TV-Longform       |
	| Product     | 10-Minute Trainer |
	| Show        | Fast Results      |
	| Region      | US                |
	| Version	  | Random			  |
	
Scenario: Verify Validation on Create Creative page
	Given user goes to Create Creative Page
	When user directly clicks on Save button
	Then user is displayed Alert to fill all required fields
	
Scenario: Create Creative with MediaType, Product, Show, Region and Version	and add Dub Master And DNIS Group
	Given user enters Media Type, Product, Show, Region, Version and Allowable on Create Creative Page
	| Field Names |   value           |
	| Media Type  | TV-Longform       |
	| Product     | 10-Minute Trainer |
	| Show        | Fast Results      |
	| Region      | US                |  
	| Allowable	  | 10				  |
	| productAbbre| TMT				  |
	| showAbbre   | FRS				  |
	
	Then user is displayed message of successful Creation of new Creative
	
	When user clicks on Dub Master tab
	Then user is shown the Dub Master tab
	When user adds Master and Sub Master Dub
	| Field Names |   value           |
	| DubHouse	  | DG Digital Generation - SEE VENDOR# 110919 EXTREME REACH       |
	| TapeType    | SD Teletrax		  |
	
Scenario: Update the Created Creative with Dub Master, DNIS Group, Permission and Translation tab
	Given user select on DNIS Group tab
	Then user is shown the DNIS Group tab
	When user adds DNIS Group
	| Field Names    | value           	      |
	| Agency	     | AOR			          |
	| Call Center    | Beachbody Call Center  |
	
	Then user verifies DNIS Group created
		
	Given user is on Search Vendor Page
	When user searches for Vendor with vendor Name and Type
	| Field Names | Value			 |
	| Vendor Name | AOR Direct, LLC  |
	| Short Name  ||
	| Abbre		  ||
	| Type		  | Agency		     |
	| Active	  | No				 |
	Then user is displayed Vendor Name on Search Vendor page
	| Field Names | Value			 |
	| Vendor Name | AOR Direct, LLC  |
	When user clicks on the Displayed Vendor
	When user add Permission & Translation to the Selected Vendor
	| Field Names | Value			 |
	| Media Type  | TV-Longform  |

Scenario: Edit Created Creative with Description
	Given user is on Search Creative Page
	Given user searches and open the creative on Search Creative page
	| Field Names |   value           |
	| Media Type  | TV-Longform       |
	| Product     | 10-Minute Trainer |
	| Show        | Fast Results      |
	| Region      | US                |
	| Version	  | Property		  |

	Given user clicks on Edit button on edit Creative Page
	When user enter Creative Description on Edit creative page
	| Field Names    | value           	      |
	| Description    | Test			          |
	
	Then user is displayed success message	
