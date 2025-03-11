Feature: SPA Market Segment

  @marketSegment
  Scenario: Create product info with valid data
    Given user in the home page
    When user enter with valid credential
    And user click MIS button and Setup button
    And user click on market segment
    And user click on add market segment
    And user enter market segment code, name and address
    And click on submit button
    Then successfully create the market segment information