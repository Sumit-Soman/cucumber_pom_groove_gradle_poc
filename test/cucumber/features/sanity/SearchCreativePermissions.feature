@qa @prod @dev @int @ext_agency
Feature: Test searching and filtering on Search Creative Permissions Page

Scenario: Search Creative Permissions with MediaType, Product, Show, Region and Agency
	
	Scenario: Verify export to excel on Search Creative Permission Page.
	Given user is on Search Creative Permissions Page
	When user click on Export to excel link on Search Creative Permission Page
	Then excel report is saved on local user machine
	Then verify the records count in excel sheet
		
Scenario: Verify Pagination on Search Creative Permission  Page
	
	Then verify Pagination is present on the Search Creative Permission Page
	When user click on Next button on Pagination on Creative Permission Page
	Then user is navigated to next Search Creative Permission Result Page
	
	Given user enters media type, product, show, region and Agency on Search Creative Permissions Page 
	| Field Names |   value           |
	| Media Type  | TV-Longform       |
	| Product     | 21 Day Fix        |
	| Show        | Sequel            |
	| Region      | US                |
	| Agency      | Apex              |
	
	When user clicks on search button on Search Creative Permissions Page
	Then user finds the required creatives by media type, product, show, region and Agency on Search Creative Permissions Page
	| Field Names | value             |
	| Media Type  | TV-Longform       |
	| Product     | 21 Day Fix        |
	| Show        | Sequel            |
	| Region      | US                |
	| Agency      | Apex              |
	
	
	
	