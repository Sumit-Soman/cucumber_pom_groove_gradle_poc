@qa @prod @dev @int @ext_agency
Feature: Test searching and filtering on Search Station Page

Scenario: Search Station with Status and Station Type

	Given user is on Search Station Page
    Given user enters Status and Station Type on Search Station Page
    | Field Name   |  Value   |
    | Status       |  Active  |
    | Station Type | National |
    
    When user clicks on search button on Search Station Page
    Then user finds the required Station by Status and Station Type on Search Station Page
    | Field Name   |  Value   |
    | Status       |  Active  |
    | Station Type | National |
