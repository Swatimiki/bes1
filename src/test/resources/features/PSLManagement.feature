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
    Then navigate back to Estimate Revisions Management
    And click on Project Specific Library dropdown
    Then click on Delete Project Specific Library option
    Then User should get error message "This shared Project-Specific Library cannot be deleted as it is already applied to a baseline."

    Examples:
      | username       | Password | expectedstatus |
      | meenal.singhal | singmeen | success        |