Feature: Search Wikipedia

  Scenario: Search for a topic on Wikipedia
    Given I am on the Wikipedia homepage
    When I search for "Red Hot Chili Peppers"
    Then I should see results containing "Red Hot Chili Peppers"