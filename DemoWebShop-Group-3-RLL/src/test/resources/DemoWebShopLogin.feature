Feature: Login functionality Demowebshop

  Scenario Outline: To test the login functionality of demowebshop page
    Given I am on Demowebshop home page
    When I click on Login 
    And I enter username "<email>"
    And I enter password "<password>"
    Then I click on Login submit button
Examples:
    | email | password |
    |       |          |
    |       |      	   |
   