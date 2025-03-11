Feature: SPA Category Info

  @categoryInfo
  Scenario: Create category info with valid data
    Given user in the home page
    When user click MIS button and Setup button
    And user click on category info
    And user click on add category info
    And user enter category code, category name, brand name and remarks
    And click on submit button
    Then successfully create the category info information