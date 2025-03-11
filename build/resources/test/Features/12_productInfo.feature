Feature: SPA Product Info

  @productInfo
  Scenario: Create product info with valid data
    Given user in the home page
    When user click MIS button and Setup button
    And user click on category product info
    And user click on add product info
    And user enter product code, product name and all information
    And click on submit button
    Then successfully create the product info information