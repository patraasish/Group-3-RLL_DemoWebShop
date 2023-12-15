Feature: Verify Add to Cart button on book pages

  Scenario: Check if all books have an Add to Cart button
     Given Navigate to url
    When I click on book link
    Then I verify first book have Add to Cart button
    And I verify second book have Add to Cart button
    And I verify third book have Add to Cart button
    And I verify fourth book have Add to Cart button
    And I verify fifth book have Add to Cart button
    Then I verify sixth book have Add to Cart button
    