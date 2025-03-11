Feature: SPA Customer Info

  @customerInfo
  Scenario: Create customer info with valid data
    Given user in the home page
    When user click MIS button and Setup button
    And user click on customer info
    And user click on add customer info
    And user enter customer code, customer name, address and others information
    And click on submit button
    Then successfully create the customer info information