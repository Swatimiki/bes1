Feature: PSL created from ONCOST Page

  Scenario Outline: Estimate page functionality
   Given Login page
   When Enter username "<username>" and password "<Password>"
   And Click on the login button
   Then Logged in based on "<expectedstatus>"
   Then User navigates to PSLONCOSTS section

    Examples:
      | username       | Password | expectedstatus |
      | meenal.singhal | singmeen | success        |
