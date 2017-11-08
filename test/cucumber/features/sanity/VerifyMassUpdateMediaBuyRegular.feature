@qa @prod @dev @int  

Feature: Test searching and filtering on Mass Update Media Buy-Regular-TV-Longform Page

  Scenario: Search Mass Update Media Buy-Regular-TV-Longform Page with Creative

    Given user is on Mass Update Media Buy-Regular-TV-Longform Page
    Given user enters Creative on Mass Update Media Buy-Regular-TV-Longform Page
      
      | Field Names |   value           						|
      | Creative    | 10-Minute Trainer / It Starts With 10 / |

    When user clicks on search button on Mass Update Media Buy-Regular-TV-Longform Page
    Then user finds the required results by Creative on Mass Update Media Buy-Regular-TV-Longform Page
      | Field Names |   value           |
      | Creative    | 10-Minute Trainer |

