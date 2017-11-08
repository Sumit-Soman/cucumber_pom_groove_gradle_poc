@qa @prod @dev @int

Feature: Test Functionality like Searching, filtering on Generate Payment Request Guarantee Page.  

  Scenario: Verify Generate Payment Request Guarantee Page.
    Given user is on Generate Payment Request Guarantee Page.
    When user selects Station Direct in drop down for vendor Type.
    When user clicks on search button on Generate Payment Request Guarantee Page.
    Then user finds the required result by Station Direct on Generate Payment Request Guarantee Page.

