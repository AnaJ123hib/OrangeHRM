Feature: Leave Management

  Background:
    Given the user is on the Leave page

  Scenario: Leave list is displayed
    Then Leave Management should be displayed

  Scenario: Search leave records by employee name
    When the user searches leave records by employee "manda akhil user"
    Then all leave records by employee "manda akhil user" should be displayed

  Scenario: Filter leave records by status
    When the user searches leave records by status "Pending Approval"
    Then all leave records by status "Pending Approval" should be displayed


