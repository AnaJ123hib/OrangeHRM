Feature: Dashboard

Background:
  Given the user is logged in

  Scenario: Dashboard is displayed after login
    Then Dashboard should be displayed

  Scenario: Quick Launch cards are displayed
    Then Quick launch widget should be displayed

  Scenario: Time at Work widget is displayed
    Then Time at work widget should be displayed

  Scenario: Employee Distribution widget is displayed
    Then Sub Unit widget should be displayed
    And Location widget should be displayed