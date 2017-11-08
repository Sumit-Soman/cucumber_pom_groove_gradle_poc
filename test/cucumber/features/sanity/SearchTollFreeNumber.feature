@qa @prod @dev @int
Feature: Test searching and filtering on Toll Free Number Page

Scenario: Search Toll Free Number with Agency and Media Type

	Given user is on Search Toll Free Number Page
    When user enters Creative on Search Toll Free Number Page
    | Field Name   | Value             |
    | Creative     | 10-Minute Trainer |
 
    When user clicks on search button on Search Toll Free Number Page
    Then user finds the required result by Creative on Search Toll Free Number Page
    | Field Name   | Value             |
    | Product      | 10-Minute Trainer |