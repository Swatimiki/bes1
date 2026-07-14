Feature: Access Revisions Management Page

   Scenario Outline: Access Revisions page functionality
    Given Login page
    When Enter username "<username>" and password "<Password>"
    And Click on the login button
    Then Logged in based on "<expectedstatus>"
     Then User navigates to Estimates section
    Then User checks the Access restrictions

    Examples:
     | username       | Password | expectedstatus |
     | meenal.singhal | singmeen | success        |
