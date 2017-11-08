@qa @prod @dev @int

Feature: Test searching and filtering on Offer Configuration Page 

Scenario: Search Offer Configuration with Product, Offer Code, Script Version, SKU and Upsell

	Given user is on Offer Configuration Page 
	Given user selects Product, Offer Code, Script Version, SKU and Upsell on Offer Configuration Page 
	| Field Names     |   value                  |
	| Product	      | 10-Minute Trainer        |
	| Offer Code	  | TWUK002	                 |
	| Script Version  | 10-Minute Trainer (134)  |
	| SKU   	      | MDTBBTMUK1	             |
	| Upsell    	  | TBB CLUB	             |	
		
	When user clicks on search button on Offer Configuration Page
	Then user finds the required result by Product as result on Offer Configuration Page
	| Field Names |   value           |
	| Product	  | 10-Minute Trainer |