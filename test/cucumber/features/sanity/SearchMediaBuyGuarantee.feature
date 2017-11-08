@qa @prod @dev @int @ext_agency 

  Feature: Test searching and filtering on Search Media Buy-Guarantee-TV Page

    Scenario: Search Media Buy-Guarantee-TV Page with Station

      Given user is on Search Media Buy-Guarantee-TV Page
      Given user enters Station on Search Media Buy-Guarantee-TV Page
        | Field Names |   value    |
        | Station     | Animal Planet - US |


      When user clicks on search button on Search Media Buy-Guarantee-TV Page
      Then user finds the required results by Station on Search Media Buy-Guarantee-TV Page
        | Field Names |   value    |
        | Station     | Animal Planet - US |
