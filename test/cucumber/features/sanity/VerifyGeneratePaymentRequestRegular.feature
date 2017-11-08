@qa @prod @dev @int

Feature: Test Functionality like Searching, filtering on Generate Payment Request Regular Page.  

  Scenario: Verify Generate Payment Request Regular Page.
    Given user is on Generate Payment Request Regular Page.
    When user selects New Status and Agency vendor type.
    When user clicks on search button on Generate Payment Request Regular Page.
    Then user finds the required result by external billed on Generate Payment Request Regular Page.

