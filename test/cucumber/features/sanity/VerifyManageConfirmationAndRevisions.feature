@qa @prod @dev @int 
Feature: Test Functionality like Searching, filtering on Manage Confirmation & Revisions Page.

  Scenario: Verify Manage Confirmation & Revisions Page.
    Given user is on Manage Confirmation & Revisions Page.
    When user selects external media buys checkbox.
    When user clicks on search button on Manage Confirmation & Revisions Page.
    Then user finds the required result by external agency on Manage Confirmation & Revisions Page.

