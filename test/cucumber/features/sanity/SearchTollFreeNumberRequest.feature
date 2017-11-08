@qa @prod @dev @int
Feature: Test searching and filtering on Toll Free Number Request Status Page

Scenario: Search Toll Free Number Request Status with Start Date

	Given user is on Search Toll Free Number Request Status Page
    When user enters Start Date on Search Toll Free Number Request Status Page
    | Field Name   |  Value     |
    | Start Date   | 03/01/2015 |
    
    
    When user clicks on search button on Search Toll Free Number Request Status Page
    Then user finds the required result by Start Date on Search Toll Free Number Request Status Page
    | Field Name   |  Value     |
    | Start Date   | 03/01/2015 |