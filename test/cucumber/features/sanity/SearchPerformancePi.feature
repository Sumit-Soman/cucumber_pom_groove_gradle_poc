@qa @prod @dev @int @ext_agency 

Feature: Test Functionality like Searching, filtering on Search Performance PI Page.

  Scenario: Search Performance PI with creative
    Given user is on Search Performance PI Page
    When user selects creative
      | Field Name  | Value    			  |
      | Creative    | Derm Exclusive /    |
 
    When user clicks on search button on Search Performance PI Page
    Then user finds the required result by creative on Search Performance PI
      | Field Name  | Value    		    |
      | Creative    | Derm Exclusive    |

