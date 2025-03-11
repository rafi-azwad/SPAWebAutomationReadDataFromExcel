Feature: SPA Retailer Category

  @retailerCategory
  Scenario: Create route with valid data
    Given user in the home page
    When user click MIS button and Setup button
    And user click on retailer category
    And user click on add retailer category
    And user enter retailer category code, retailer category name
    And click on submit button
    Then successfully create the retailer category information