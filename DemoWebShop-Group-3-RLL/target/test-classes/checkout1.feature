
Feature: test the webshop page
  

  
  Scenario Outline: Checkout Test on page
    Given  User open the chrome browser and enter URL
    When User click on login 
    Then User enter email "<email>"
    Then User enter password "<password>"
    Then User click on login button
    When User click on books tab
    Then User click on third book
    And User click on Add to cart button
    When User click on shopping cart page
    Then User Click on terms of service check box
    Then User click on checkout button
    When User Fill The Billing Address Form
    Then User click on Billing Address Continue button
    Then User click on  In Store Pickup check box
    And User click on Shipping Address Continue button
    Then User click on first image
    And User click on Payment Method Continue button
    Then User click on Payment Information Continue button
    And  User click on confirm button
    Then User should see the successfull message
  Examples: 
  |email	 |password|
  |				 |				|
    
    
    
    
    
    
   
 
