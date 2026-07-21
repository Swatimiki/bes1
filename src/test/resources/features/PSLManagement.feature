Feature: PSL created from Estimate Revisions Management page using existing from Baseline

  Scenario Outline: Project Specific Library functionality
    Given Login page
    When Enter username "<username>" and password "<Password>"
    And Click on the login button
    Then Logged in based on "<expectedstatus>"
    Then User navigates to Estimate Revisions Management Page
    Then User navigate to Project Specific Library section
    Then User clicks on use existing from another baseline
    Then User selects estimate from the popup
    Then User clicks on save
    Then User views Project Specific Library
    Then navigate back to Project Specific Library Sectionss
    Then click on Delete Project Specific Library option
    Then User should get error message "The Shared Project Specific Library can't be deleted as it is applied to baselines"

    Examples:
      | username       | Password | expectedstatus |
      | meenal.singhal | singmeen | success        |