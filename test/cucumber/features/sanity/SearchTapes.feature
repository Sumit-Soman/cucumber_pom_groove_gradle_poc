@qa @prod @dev @int @ext_agency

Feature: Test searching and filtering on Search Tapes Page

Scenario: Search Tapes with MediaType, Creative and Agency
	
	Given user is on Search Search Tapes Page
	Given user enters Media Type, Creative and Agency on Search Tapes Page
	| Field Names |   value           |
	| Media Type  | TV-Longform       |
	| Creative    | 10-Minute Trainer |
	| Agency      | AOR               |
	
	When user clicks on search button on Search Tapes Page
	Then user finds the required tapes by media type on Search Tapes Page
	| Field Names |   value           |
	| Product     | 10-Minute Trainer |
