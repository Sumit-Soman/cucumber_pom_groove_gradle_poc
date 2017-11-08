@qa @prod @dev @int @ext_agency 
Feature: Test Functionality like Searching, filtering on Search Response Data Page.

  Scenario: Search Response Data with Product
    Given user is on Search Response Data Page
    When user selects product
      | Field Name  | Value             |
      | Product     | 10-Minute Trainer |
    When user blanks Starting Date on Search Response Data Page
    When user clicks on search button on Search Response Data Page
    Then user finds the required result by product on Search Response Data Page
      | Field Name  | Value             |
      | Product     | 10-Minute Trainer |
