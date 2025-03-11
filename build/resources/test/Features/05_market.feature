Feature: SPA Market
  @market
  Scenario: Create product info with valid data
    Given user in the home page
    When user enter with valid credential
    And user click MIS button and Setup button
    And user click on market
    And user click on add market
    And user enter market code, name and other information
    And click on submit button
    Then successfully create the market information