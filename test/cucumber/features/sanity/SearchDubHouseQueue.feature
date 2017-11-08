@qa @prod @dev @int 
Feature: Test searching and filtering on Dub House Queue Page

  Scenario: Search Dub House queue with Dub House
    When user is on the Dub House Queue Page
    When user selects Dub House
      | Field Names | value     |
      | Dub House   | Treehouse |
      | Status      | RECEIVED  |
    When user clicks on search button on Dub House queue Page
    Then user finds the required result by Dub House on Dub House queue Page
      | Field Names | value     |
      | Dub House   | Treehouse |
