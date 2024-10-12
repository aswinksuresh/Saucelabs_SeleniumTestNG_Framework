Feature: Verify end-to-end scenarios of the application

  Scenario: Verify user can place order
    Given user opens the website
    Then verify user is on the login page
    When user logs in with valid username and password
    Then verify user is on the home page
    When user clicks on the add to cart button of the first item
    Then verify the cart icon displays a quantity of one
    When user clicks on the cart icon
    Then verify user is on the cart page
    When user clicks on the checkout button
    Then verify user is on the checkout page
    When user fills all checkout details
    And clicks on the Continue button
    Then verify user is on the review page
    When user clicks on the Finish button
    Then verify user is on the order confirmation page