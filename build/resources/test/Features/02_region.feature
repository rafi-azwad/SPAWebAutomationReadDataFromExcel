Feature: SPA Region

  @region
  Scenario: Create region with valid data
    Given user in the home page
    When user click MIS button and Setup button
    And user click on region
    And user click on add region
    And user enter region code, region name
    And click on submit button
    Then successfully create the region information