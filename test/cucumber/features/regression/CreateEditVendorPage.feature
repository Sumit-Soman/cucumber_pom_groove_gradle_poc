@qa @prod @dev @int

Feature: Test Create and Edit feature of Vendor on Vendor Page
Scenario: Search for existing Vendor
	Given user is on Search Vendor Page.
	When user fills the search form and click on search button 
	| Field Names     |   value           |
	| Vendor Type     | Agency		      |
	| Full Name   	  | Random 			  |
	| Abbreviation    | VR			      |
	| Short Name	  | Vendor			  |

Scenario: Create a new Vendor on Vendor page
	Given user navigates to Create Vendor Page
	When user fill the vendor details and clicks on Save button
	| Field Names     |   value           |
	| Vendor Type     | Agency		      |
	| Full Name   	  | Property 		  |
	| Abbreviation    | VR			      |
	| Media Buy Type  |  12               |
	Then user is moved to Vendor Details tab
	
Scenario: Add Contact to Vendor
	Given user moves to Contact Tab and clicks on Create Contact button
	Then user add Contact details
	| Field Names     |   value           |
	| Name     		  |  Property	      |

Scenario: Edit Media Buy Type for the Vendor
	Given user moves to Vendor Tab
	When user clicks on Edit button
	When user select Guarantee Buy Type and click the save button
	Then Vendor is saved successfully
#Scenario: Add Permission and Translation details to Vendor
#	Given user moves to Permission and Translation Tab 
#	Then user add Permission and Translation details
#	| Field Names     |   value           |
#	| Creative        | 10-Minute Trainer / Fast Results / 001 / US / English / TV-Longform / -		      |
#	| End Date		  | 12/31/2021	      |
#	| Media Type  	  |  TV-Longform      |
	