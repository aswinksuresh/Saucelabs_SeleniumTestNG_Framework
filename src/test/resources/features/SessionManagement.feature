Feature: Verify application manages state of user

  Scenario: Verify application saves state of user
    Given user open website
    Then verify user os on login page
    When user login valid username and password
    Then verify user is on home page
    When user click on add to cart button of the first item
    Then verify cart icon displays quantity one
    When user click on hamburger menu
    And click on logout link
    Then  verify user is on home page
    When user login valid username and password
    Then verify user is on home page
    And verify add to cart button for first item is not displayed
