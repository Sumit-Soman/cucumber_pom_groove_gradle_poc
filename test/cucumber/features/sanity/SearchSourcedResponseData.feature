@qa @prod @dev @int @ext_agency 

Feature: Test Functionality like Searching, filtering on Search Sourced Response Data Page.

  Scenario: Search Sourced Response Data with product
    Given user is on Search Sourced Response Data Page
    When user selects Product
      | Field Name  | Value             |
      | Product     | 10-Minute Trainer |
    When user clicks on search button on Search Sourced Response Data Page
    Then user finds the required result by product on Search Sourced Response Data Page
      | Field Name  | Value             |
      | Product     | 10-Minute Trainer |