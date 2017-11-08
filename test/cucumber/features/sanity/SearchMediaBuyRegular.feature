@qa @prod @dev @int @ext_agency  

  Feature: Test searching and filtering on Search Media Buy-Regular-TV Page

    Scenario: Search Media Buy-Regular-TV Page with Status and Creative

      Given user is on Search Media Buy-Regular-TV Page
      Given user enters Status and Creative on Search Media Buy-Regular-TV Page
        | Field Names |   value           						|
        | Status      | Active       							|
        | Creative    | 10-Minute Trainer / It Starts With 10 / |

      When user clicks on search button on Search Media Buy-Regular-TV Page
      Then user finds the required results by Status and Creative on Search Media Buy-Regular-TV Page
        | Field Names |   value           |
        | Status      | Active       	  |
        | Product     | 10-Minute Trainer |
		| Show        | It Starts With 10 |
