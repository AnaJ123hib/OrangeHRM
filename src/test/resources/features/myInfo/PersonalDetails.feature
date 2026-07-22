Feature: Personal Details
  Background:
    Given the user is on Personal Details page

  Scenario: Personal Details page is displayed
    Then the Personal Details page should be displayed

  Scenario: Update first name
    When the user updates the first name
    Then the updated first name should be displayed in Personal Details

  Scenario: Update last name
    When the user updates the last name
    Then the updated last name should be displayed in Personal Details

  Scenario: Update nationality
    When the user updates the nationality
    Then the updated nationality should be displayed in Personal Details

  Scenario: Update marital status
    When the user updates the marital status
    Then the updated marital status should be displayed in Personal Details

  Scenario: Update date of birth
    When the user updates the date of birth
    Then the updated date of birth should be displayed in Personal Details