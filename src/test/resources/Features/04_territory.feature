Feature: SPA Territory

  @territory
  Scenario: Create territory with valid data
    Given user in the home page
    When user click MIS button and Setup button
    And user click on territory
    And user click on add territory
    And user enter territory code, territory name, address and remarks
    And click on submit button
    Then successfully create the territory information