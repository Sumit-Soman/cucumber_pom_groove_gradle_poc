@qa @prod @dev @int @ext_agency 

Feature: Test Functionality like Searching, filtering on Search Payout Page.  

  Scenario: Verify Search Payout Page.
    Given user is on Search Payout Page.
    When user selects regular in drop down for media buy Type on Search Payout Page.
    When user clicks on search button on Search Payout Page.
    Then user finds the required result by Regular on Search Payout Page.

