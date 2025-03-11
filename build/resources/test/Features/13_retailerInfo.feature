Feature: SPA Retailer Info

  @retailerInfo
  Scenario: Create product info with valid data
    Given user in the home page
    When user enter with valid credential
    And user click MIS button and Setup button
    And user click on retailer info
    And user click on add retailer info
    And user enter retailer code, retailer name and all information
    And click on submit button
    Then successfully create the retailer info information