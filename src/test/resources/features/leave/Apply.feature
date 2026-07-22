Feature: Apply

  Background:
    Given the user is on Apply Leave page

  Scenario: Apply page is displayed
    Then Apply page should be displayed

  Scenario: Apply for leave with valid information
    When the user applies leave with valid information
    Then the leave request should be displayed in the leave list

  Scenario: Cancel pending leave request
    Given a pending leave request exists
    When the user cancels the leave request
    Then the leave request status should be Cancelled

