Feature: SPA Area

  @area
  Scenario: Create area with valid data
    Given user in the home page
    When user click MIS button and Setup button
    And user click on area
    And user click on add area
    And user enter area code, name and remarks
    And click on submit button
    Then successfully create the area information