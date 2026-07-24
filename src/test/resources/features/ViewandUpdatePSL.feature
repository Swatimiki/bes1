Feature: View and Update Project Specific Library functionality

  Scenario Outline: View and update EPD details in Project Specific Library

    Given Login page
    When Enter username "<username>" and password "<Password>"
    And Click on the login button
    Then Logged in based on "<expectedstatus>"
    Then User navigates to Estimate Revisions Management Page
    Then User navigate to Project Specific Library section
    Then User views Project Specific Library
    Then User clicks on View or Update button
    And User updates the EPD details in the popup
   # And User clicks on save button in the popup
    #Then Updated EPD details should be highlighted in Project Specific Library
    #When User clicks on save button in Project Specific Library Page
    #Then User should verify the updated EPD details in the popup
    #Then User clicks on close button

    Examples:
      | username       | Password | expectedstatus |
      | meenal.singhal | singmeen | success        |
