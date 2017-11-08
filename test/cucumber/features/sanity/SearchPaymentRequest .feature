@qa @prod @dev @int @ext_agency

Feature: Test Functionality like Searching, filtering on Search Payment Request Page.  

  Scenario: Verify Search Payment Request Page.
    Given user is on Search Payment Request Page.
    When user selects regular in drop down for media buy Type.
    When user clicks on search button on Search Payment Request Page.
    Then user finds the required result by Regular on Search Payment Request Page.

