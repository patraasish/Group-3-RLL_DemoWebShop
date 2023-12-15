#Author: your.email@your.domain.com

Feature: Test the Recently viewed product functionality

  Scenario: Recently viewed product Test on page
    Given User navigate to URL
    Then User click on Books link
    When Usen click on a Book
    Then User go to home page
    Then User should able to see that product in Recently viewed product
