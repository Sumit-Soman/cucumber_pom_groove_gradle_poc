@qa @prod @dev @int 

Feature: Test searching and filtering on Search Dub House Job Request Page

Scenario: Search Dub House Request with Dub House and Creative
	
	Given user is on Search Dub House Job Request Page
	Given user enters Dub House and Creative on Search Dub House Job Request Page
	| Field Names | Value                                   |
	| Dub House   | Treehouse                               |
	| Creative    | 10-Minute Trainer / It Starts With 10 / |
	
	When user clicks on search button on Search Dub House Request Page
	Then user finds the required requests by Dub House and Creative on Search Dub House Job Request Page
	| Field Names | Value                                   |
	| Dub House   | Treehouse                               |
	| Creative    | 10-Minute Trainer / It Starts With 10 / |
