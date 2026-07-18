Feature: PSL created from Estimate Revisions Management page using existing from Baseline

  Scenario Outline: Project Specific Library functionality
    Given Login page
    When Enter username "<username>" and password "<Password>"
    And Click on the login button
    Then Logged in based on "<expectedstatus>"
    #Then User navigates to Estimate Revisions Management Page
    Then User navigate to Project Specific Library section

    Examples:
      | username       | Password | expectedstatus |
      | meenal.singhal | singmeen | success        |