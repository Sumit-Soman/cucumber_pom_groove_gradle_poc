@qa @prod @dev @int 

Feature: Test Functionality like Searching, filtering on Offer or Script or Duplicate Errors Page.

  Scenario: Search Offer or Script or Duplicate Errors with product
    Given user is on Offer or Script or Duplicate Errors Page
    When user selects Product on Offer or Script or Duplicate Errors Page
      | Field Name  | Value             |
      | Product     | 21 Day Fix        |
    When user clicks on search button on Offer or Script or Duplicate Errors Page
    Then user finds the required result by product on Offer or Script or Duplicate Errors Page
      | Field Name  | Value             |
      | Product     | 21 Day Fix        |