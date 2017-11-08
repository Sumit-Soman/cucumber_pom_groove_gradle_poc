@qa @prod @dev @int @ext_agency 
Feature: Test Functionality like Searching, filtering on Search Performance Regular Page.

  Scenario: Search Performance Regular with Local Date From and Loca Date To
    Given user is on Search Performance Regular Page
    When user selects Local Date From and Loca Date To
      | Field Name      | Value             |
      | Local Date From | 01/12/2015	    |
      | Local Date To   | 01/12/2015	    |
    When user clicks on search button on Search Performance Regular Page
    Then user finds the required result by Local Date From and Loca Date To on Search Performance Regular
      | Field Name      | Value             |
      | Local Date      | 01/12/2015	    |

