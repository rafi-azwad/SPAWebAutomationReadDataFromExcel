Feature: SPA Brand Info

  @brandInfo
  Scenario: Create brand info with valid data
    Given user in the home page
    When user click MIS button and Setup button
    And user click on brand info
    And user click on add brand info
    And user enter brand code, brand name, brand type and remarks
    And click on submit button
    Then successfully create the brand info information