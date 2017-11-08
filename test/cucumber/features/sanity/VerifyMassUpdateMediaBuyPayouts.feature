@qa @prod @dev @int  

Feature: Test searching and filtering on Mass Update Media Buy Payouts Page

  Scenario: Search Mass Update Media Buy Payouts Page with Creative

    Given user is on Mass Update Media Buy Payouts Page
    Given user enters Creative on Mass Update Media Buy Payouts Page
      | Field Names |   value           						|
      | Creative    | 10-Minute Trainer / It Starts With 10 / |

    When user clicks on search button on Mass Update Media Buy Payouts Page
    Then user finds the required results by Creative on Mass Update Media Buy Payouts Page
      | Field Names |   value           |
      | Product     | 10-Minute Trainer |
  		| Show        | It Starts With 10 |