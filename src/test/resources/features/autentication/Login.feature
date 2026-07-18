Feature: Authentication
  As a registered OrangeHRM user
  I want to authenticate with my credentials
  So that I can access the application

  Background: Navigate to login page
    Given the user is on OrangeHRM login page

  Scenario: Successfully login with valid credentials
    When the user logins with valid credentials
    Then Dashboard should be displayed

  Scenario: Login with invalid password
    When the user logs in with invalid credentials
    Then the message "Invalid credentials" should be displayed

  Scenario: Login with non-existed username
    When the user logins with unregistered username
    Then the message "Invalid credentials" should be displayed

  Scenario: Login with empty required fields
    When the user attempts to log in without entering credentials
    Then the username field should display a required validation message
    And the password field should display a required validation message

