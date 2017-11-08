@qa @prod @dev @int  
Feature: Test searching and filtering on Search Vendor Page


Scenario: Search vendor with Vendor Type
    Given user is on Search Vendor Page
    
    Given user enters Vendor Type on Search Vendor Page
    | Field Name  | Value  |
    | Vendor Type | Agency |
    When the user clicks on search button on Search Vendor Page
    Then user finds the required Vendor by Full Name and Vendor Type on Search Vendor Page
    | Field Name  | Value  |
    | Vendor Type | Agency |
