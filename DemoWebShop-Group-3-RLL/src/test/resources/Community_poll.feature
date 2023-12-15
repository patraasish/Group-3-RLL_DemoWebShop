Feature: Validate Community Poll functionality with and without login

  Scenario: Attempt to vote without login
    Given the user accesses the community poll section
    When the user attempts to vote without logging in
    Then the system should display the message Only registered users can vote
    
    Scenario Outline: Login and cast a vote
    Given the user navigate to url
    Then the user click on login
    And the user enter email "<email>"
    And the user enter password "<password>"
    And the user click on login button
    And  the user accesses the community poll section when loged in
    When the user casts a vote for any option
    Then the system should display the accurate voting percentage
Examples: 
  |email	 |password|
  |				 |				|


 
 