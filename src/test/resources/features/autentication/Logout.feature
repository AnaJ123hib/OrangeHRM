Feature: Logout
  Background:
    Given the user is logged in

  Scenario: Successful logout
    When the user logs out
    Then the login page should be displayed