@qa @prod @dev @int

Feature: Test searching and filtering on Search Creative Page and open a creative to verify all tabs

Scenario: Search creative with MediaType, Product, Show, Region and Active Status

	Given user is on Search Creative Page
	Given user enters media type, product, show and region on Search Creative Page 
	| Field Names |   value           |
	| Media Type  | TV-Longform       |
	| Product     | 10-Minute Trainer |
	| Show        | Fast Results      |
	| Region      | US                |
	
	When user clicks on search button on Search Creative Page
	Then user finds the required creatives by media type, product, show and region as result on Search Creative Page
	| Field Names | value             |
	| Media Type  | TV-Longform       |
	| Product     | 10-Minute Trainer |
	| Show        | Fast Results      |
	| Region      | US                |
	
Scenario: Check all tabs of Creative Details

	When user clicks on a creative from the result 
	Then user navigates to the creative details page with Creative Details Tab
	
	When user clicks on Allowable tab 
	Then user is shown the Allowable tab
	
	When user clicks on Dub Master tab
	Then user is shown the Dub Master tab
	
	When user clicks on DNIS Group tab
	Then user is shown the DNIS Group tab

	When user clicks on Permissions & Translations tab
	Then user is shown the Permissions & Translations tab
	