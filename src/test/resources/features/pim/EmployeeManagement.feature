Feature: Employee Management

  Background:
    Given the user is on the Employee Management page

  Scenario: Employee List page is displayed
    Then Employee Management page should be displayed

  Scenario: Search employee by employee name
    When the user search an employee by name
    Then the employee should be displayed

  Scenario: Search employee by employee id
    When the user search an employee by id
    Then the employee id should be displayed

  Scenario: Add a new employee
    Given the user is in Add Employee page
    When the user creates a new employee with valid information
    Then the new employee should be displayed in the results table

  Scenario: Update employee personal information
    Given the user is in Add Employee page
    When the user updates the created employee with valid information
    Then the edited employee should be displayed
