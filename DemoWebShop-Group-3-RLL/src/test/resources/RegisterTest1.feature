Feature: Test the Register functionality


  Scenario Outline: User registration 
   
    When user is on home page
   Then user click on register link
   Then user select gender
    And user enter First Name "<firstname>"
    Then user enter Last Name "<lastname>"
    And user enter email "<email>"
    When user enter password "<password>"
    Then user enter confirm password "<confirmpassword>"
    And user click on register
    
Examples:
    | firstname | lastname | email | password | confirmpassword |
    |      		  |          |			 |					|									|
    |       		|      	   |			 |					|									|
  	|						|					 |			 |					|									|