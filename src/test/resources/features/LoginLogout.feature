Feature: Validate login functionality

  Background:
    Given user open website
    Then verify user is on login page
  @Smoke
  Scenario: Verify user can login with valid credentials
    When user login valid with username "admin" and password "password"
    Then verify user is on homepage

  Scenario Outline: Verify user cannot login with invalid credentials
    When user login valid with username "<username>" and password "<password>"
    Then verify invalid login error message is displayed
  Examples:
    |username||password|
    |invalid||invalid123|
    |admin||ADMIN123d|
    |admin||adminOneTwoThree|
  Scenario: Verify user can logout of the application
    When user login valid with username "admin" and password "password"
    Then verify user is on homepage
    When user click on hamburger menu
    And click on logout link
    Then verify user is on login page

    Scenario: Verify list usernames displays on login page
      Then verify list of below username displays on login page
    |standard_user          |standard_user          |
    |locked_out_user        |locked_out_user        |
    |problem_user           |problem_user           |
    |performance_glitch_user|performance_glitch_user|
