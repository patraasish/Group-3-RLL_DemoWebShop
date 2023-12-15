
Feature: Validate the Add to cart


  Scenario: Validate the Add to cart
    Given User open on demoshop url
    Then User click on the book
    When User add the third book to the cart
    Then The User should see a confirmation message
    And User click on shopping cart
    And User should see that product available in shopping cart
    

 