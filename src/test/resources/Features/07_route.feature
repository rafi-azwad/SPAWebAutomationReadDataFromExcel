Feature: SPA Route

  @route
  Scenario: Create route with valid data
    Given user in the home page
    When user click MIS button and Setup button
    And user click on route
    And user click on add route
    And user enter route code, route name, address and remarks
    And click on submit button
    Then successfully create the route information