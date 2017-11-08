@qa @prod @dev @int

Feature: Test Validation Pagination, Export to Excel, Searching on DNIS Call Center Page
	
Scenario: Verify export to excel on Search DNIS/Call Center Page.
	Given user is on DNISCallCenter Search Page
	When user click on Export to excel link on Search DNISCallCenter Page
	Then DNISCallCenter excel report is saved on local machine
	Then verify the DNISCallCenter records count in excel
	
Scenario: Verify Pagination on DNIS/Call Center Search  Page
	Then verify Pagination is present on the Search DNISCallCenter Page
	When user click on Next button of Pagination on the Search DNISCallCenter Page
	Then user is navigated to next set of DNISCallCenter records
	
Scenario: Verify Search fucntionality on DNISCallCenter Search Page
	When user enters Call Center, DNIS Group and Media Type
	| Field Names |   value  			|
	| DNIS Group  |  10-Minute Trainer	|
	| Call Center |	 Beachbody			|
	| Media Type  | TV-Longform 		|
	When user clicks on Search button on DNIS Call Center Page
	Then required DNIS Call Center records are populated on the page
	| Field Names |   value  			|
	| DNIS Group  |  10-Minute Trainer	|
	| Call Center |	 Beachbody			|
	| Media Type  | TV-Longform 		|
