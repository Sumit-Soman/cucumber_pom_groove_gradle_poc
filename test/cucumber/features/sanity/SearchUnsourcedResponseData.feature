@qa @prod @dev @int 

Feature: Test Functionality like Searching, filtering on Search Unsourced Response Data Page.

  Scenario: Search Unaired Response Data with product
    Given user is on Search unsourced Response Data Page
    When user selects Unaired tab
    When user selects the Product for Search unsourced Response Data
      | Field Name  | Value             |
      | Product     | 10-Minute Trainer |
    When user clicks on search button on Search Unsourced Response Data Page
    Then user finds the required result by product on Search Unsourced Response Data Page
      | Field Name  | Value             |
      | Product     | 10-Minute Trainer |