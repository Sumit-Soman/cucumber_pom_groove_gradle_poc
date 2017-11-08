@qa @prod @dev @int @ext_callcenter 

Feature: Test searching and filtering on Search Media Assignments Page  

Scenario: Search Media Assignments with Creative, Agency and Media Type 
    
    Given user is on Search Media Assignments Page
    Given user enters Creative, Agency and Media Type on Search Media Assignments Page
    | Field Name | Value                  |
    | Creative   | Shakeology /           |
    | Agency     | Beachbody Media        |
    | Media Type | Email                  |
    
    When user clicks on search button on Search Media Assignments Page
    Then user finds the required Media Assignments by Product, Agency and Media Type on Search Media Assignments Page
    | Field Name | Value                  |
    | Product    | Shakeology             |
    | Agency     | Beachbody Media        |
    | Media Type | Email                  |
    