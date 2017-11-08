@qa @prod @dev @int

Feature: Test searching and filtering on LTV Continuity Page 

Scenario: Search LTV Continuity with Product, Offer Code, Script Version, SKU and Upsell

	Given user is on LTV Continuity Page 
	Given user selects Product, Media Type, Call Center and Upsell on LTV Continuity Page 
	| Field Names     |   value                  |
	| Product	      | 10-Minute Trainer        |
	| Media Type	  | TV-Longform	             |
	| Call Center     | Beachbody Call Center    |
	| Upsell   	      | ACTIVIT	                 |
			
	When user clicks on search button on LTV Continuity Page
	Then user finds the required result by Product as result on LTV Continuity Page
	| Field Names |   value           |
	| Product	  | 10-Minute Trainer |