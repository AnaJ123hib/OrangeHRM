Feature: Admin Module

  Background:
    Given the user is logged in

  Scenario: Navigate to the Admin module
    When the user navigates to the Admin module
    Then the Admin page should be displayed