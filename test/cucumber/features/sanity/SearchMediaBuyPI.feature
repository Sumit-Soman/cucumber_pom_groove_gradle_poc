@qa @prod @dev @int @ext_agency  

  Feature: Test searching and filtering on Search Media Buy-PI-TV Page

    Scenario: Search Media Buy-PI-TV Page with Media Type and Creative

      Given user is on Search Media Buy-PI-TV Page
      Given user enters Media Type and Creative on Search Media Buy-PI-TV Page
        | Field Names |   value           						|
        | Media Type  | TV-Longform       						|
        | Creative    | 10-Minute Trainer / It Starts With 10 / |

      When user clicks on search button on Search Media Buy-PI-TV Page
      Then user finds the required results by Media Type and Creative on Search Media Buy-PI-TV Page
        | Field Names |   value           |
        | Media Type  | TV-Longform       |
        | Product     | 10-Minute Trainer |
        | Show        | It Starts With 10 | 