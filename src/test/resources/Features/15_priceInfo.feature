Feature: SPA Price Info

  @priceInfo
  Scenario: Create product info with valid data
    Given user in the home page
    When user enter with valid credential
    And user click MIS button and Setup button
    And user click on price info
    And user click on add price info
    And user enter price date, retailer code and other information
    And click on submit button
    Then successfully create the price info information