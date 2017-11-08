@qa @prod @dev @int @ext_agency

  Feature: Test searching and filtering on Search Performance Media Buy - Guarantee - TV Page

    Scenario: Search Performance Media Buy-Guarantee-TV Page with Media Type, Station Type, Creative and Region

      Given user is on Search Performance Media Buy-Guarantee-TV Page
      Given user enters Media Type, Station Type, Creative and Region on Search Performance Media Buy-Guarantee-TV Page
        | Field Names  |   value           			|
        | Media Type   | TV-Longform       			|
        | Station Type | National          			|
        | Creative     | Hip Hop Abs / New Look /   |
        | Region       | US                			|

      When user clicks on search button on Search Performance Media Buy-Guarantee-TV Page
      Then user finds the required results by Media Type, Station Type, Creative and Region on Search Performance Media Buy-Guarantee-TV Page
        | Field Names  |   value      |
        | Media Type   | TV-Longform  |
        | Station Type | National     |
        | Product      | Hip Hop Abs  |
        | Show		   | New Look     |
        | Region       | US           |
