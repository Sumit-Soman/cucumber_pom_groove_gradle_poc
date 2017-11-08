@qa @prod @dev @int

Feature: Add Affiliations on Station Affiliations Page 

Scenario: Add Affiliations

	Given user is on Station Affiliations Page 
	Given user adds Affiliation on Station Affiliations Page 
	| Field Names |   value      |
	| Affiliation  | Random  |
	Then user verify the added Affiliation on Station Affiliations Page      
