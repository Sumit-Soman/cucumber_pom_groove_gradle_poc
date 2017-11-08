@qa @prod @dev @int

Feature: Create and Edit Station Translation on Station Translations Page 

Scenario: Search and Create for existing Station Translation with Station on Station Translation Page.

	Given user is on Station Translation Page
	Given user adds Station, Agency, Agency Code on Search Station Translations Page 
	| Field Names |   value  |
	| Translation |  10News2 |
	| Agency	  |  Airtime	 |
	| Agency Station Code| A  |
	Then user verify the no Station Translation exist on Station Affiliations Page 
	
	Given user click on Create Station Translation
	Given user adds Station name, Agency and Code on Create Station Translation Page
	| Field Names |   value  |
	| Translation | 10News2 |
	| Agency	  | Airtime	 |
	| Agency Station Code| A  |   
	Then user verifies newly created Station Translation  
	| Field Names |   value  |
	| Translation |  10News2 |
	| Agency	  |  Airtime	 |
	| Agency Station Code| Property  |