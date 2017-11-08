@qa @prod @dev @int @ext_agency

Feature: Test Validation, Pagination, Export to Excel, Searching and Filtering on DNISOffer Page
	
Scenario: Verify export to excel on Search DNIS/Offer Page.
	Given user is on DNISOffer Search Page
	When user click on Export to excel link on Search DNISOffer Page
	Then DNISOffer excel report is saved on local machine
	Then verify the DNISOffer count in excel
	
Scenario: Verify Pagination on DNIS/Offer Search  Page
	Then verify Pagination is present on the Search DNISOffer Page
	When user click on Next button of Pagination on the Search DNISOffer Page
	Then user is navigated to next set of records
	
Scenario: verify Search fucntionality on DNISOffer Seacrh Page
	When user enters DNIS Group and Offer Type
	| Field Names  |   value  			|
	|	DNIS Group |  10-Minute Trainer	|
	|	Offer Type |		Test	|
	When user clicks on Search button
	Then required DNIS Group records are populated on the page
	| Field Names  |   value  			|
	|	DNIS Group |  10-Minute Trainer	|
	|	Offer Type |		Test	|
