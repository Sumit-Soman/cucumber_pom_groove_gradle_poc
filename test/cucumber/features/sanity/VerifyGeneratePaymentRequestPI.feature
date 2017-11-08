@qa @prod @dev @int

Feature: Test Functionality like Searching, filtering on Generate Payment Request PI Page.  

  Scenario: Verify Generate Payment Request PI Page.
    Given user is on Generate Payment Request PI Page.
    When user selects Agency and Station for vendor Type.
    When user clicks on search button on Generate Payment Request PI Page.
    Then user finds the required result by Agency on Generate Payment Request PI Page.

