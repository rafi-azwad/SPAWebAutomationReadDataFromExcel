Feature: SPA Factory Info

  @factoryInfo
  Scenario: Create product info with valid data
    Given user in the home page
    When user enter with valid credential
    And user click MIS button and Setup button
    And user click on factory info
    And user click on add factory info
    And user enter factory code, retailer name and address
    And click on submit button
    Then successfully create the factory info information