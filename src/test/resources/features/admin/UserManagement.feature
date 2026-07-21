Feature: User Management

  Background:
    Given the user is on the User Management page

  Scenario: Search user by username
    When the user searches for username "Admin"
    Then all users should have username "Admin"

  Scenario: Filter users by role
    When the user filters by role "Admin"
    Then all users should have role "Admin"

  Scenario: Filter users by status
    When the user filters by status "Enabled"
    Then all users should have status "Enabled"

  Scenario: Reset search filters
    Given the user has entered a value in at least one search filter
    When the user clicks the Reset button
    Then all search filters should be cleared

  Scenario: Create a new user
    When the user creates a new user with valid information
    Then the new user should be displayed in the results table

  Scenario: Update an existing user
    Given a valid user has been created
    When the user updates the created user with valid information
    Then the created user should be displayed with the updated data in the result table

  Scenario: Delete an existing user
    Given a valid user has been created
    When the user deletes the created user
    Then the created user shouldn't be displayed the result table
