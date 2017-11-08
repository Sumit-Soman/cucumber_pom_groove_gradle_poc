@qa @prod @dev @int @ext_callcenter

Feature: Test searching and filtering on Media Assignment Queue Page

  Scenario: Search Media Assignment Queue with Status
    When user is on the Media Assignment Queue Page
    When user selects Status
      | Field Names | value    |
      | Status      | RECEIVED |
    When user clicks on search button on Media Assignment queue Page
    Then user finds the required result by Call Center on Media Assignment queue Page
      | Field Names | value     |
      | Status      | RECEIVED  |
