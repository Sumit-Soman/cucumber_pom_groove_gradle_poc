@qa @prod @dev @ext_agency

Feature: Test searching and filtering on Invoice Upload History Page  

Scenario: Search Invoice Upload History with File Type
    
    Given user is on Invoice Upload History Page  
    Given user enters File Type on Invoice Upload History Page
    | Field Name         | Value      |
    | File Type          | All        |
    
    When user clicks on search button on Invoice Upload History Page  
    Then user finds the required records with File Type as Supporting Document or Invoice File on Invoice Upload History Page
    | Field Names | Value                |
	| Status	  | Supporting Document  |
	| Status	  | Invoice File	     |	