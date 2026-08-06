Feature: Estimate Baseline Page

  Scenario Outline: Estimate Baseline page functionality
    Given Login page
    When Enter username "<username>" and password "<Password>"
    And Click on the login button
    Then Logged in based on "<expectedstatus>"
    Then User navigates to Estimates section
    Then User navigates to Estimate Baseline Page
    And User edit any Resources

    Examples:
      | username       | Password | expectedstatus |
      | meenal.singhal | singmeen | success        |
