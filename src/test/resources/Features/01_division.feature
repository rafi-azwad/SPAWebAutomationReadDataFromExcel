Feature: SPA Division

  @division
  Scenario: Create division with valid data
    Given user in the home page
    When user enter with valid credential
    And user click MIS button and Setup button
    And user click on division
    And user click on add division
    And user enter division name, division code
    And click on submit button
    Then successfully create the division information