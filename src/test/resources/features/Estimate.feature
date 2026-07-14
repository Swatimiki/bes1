Feature: Estimate Revisions Management Page

  Scenario Outline: Estimate page functionality
    Given Login page
    When Enter username "<username>" and password "<Password>"
    And Click on the login button
    Then Logged in based on "<expectedstatus>"
    Then User navigates to Estimates section
    Then User navigates to Authorization section

    Examples:
      | username       | Password | expectedstatus |
      | meenal.singhal | singmeen | success        |
