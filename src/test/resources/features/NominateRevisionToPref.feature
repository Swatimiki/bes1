Feature: Nominating the Revision To Preferred Status

  Scenario Outline: Estimate page functionality
    Given Login page
    When Enter username "<username>" and password "<Password>"
    And Click on the login button
    Then Logged in based on "<expectedstatus>"
    Then Admin navigates to Nominate Revisions section

    Examples:
      | username       | Password | expectedstatus |
      | nikita.kature | Welcome123 | success        |

  Scenario Outline: Estimate page functionality
    Given Login page
    When Enter username "<username>" and password "<Password>"
    And Click on the login button
    Then Logged in based on "<expectedstatus>"
    Then Admin2 authorised the revision



    Examples:
      | username       | Password | expectedstatus |
      | meenal.singhal | singmeen | success        |




  Scenario Outline: Estimate page functionality_Contractor
    Given Login page
    When Enter username "<username>" and password "<Password>"
    And Click on the login button
    Then Logged in based on "<expectedstatus>"
    Then Contractor navigates to Revisions section

    Examples:
      | username       | Password | expectedstatus |
      | john.mcgarrigle | Welcome123 | success        |


  Scenario Outline: Estimate page functionality
    Given Login page
    When Enter username "<username>" and password "<Password>"
    And Click on the login button
    Then Logged in based on "<expectedstatus>"
    Then Admin complete the review complete process


    Examples:
      | username       | Password | expectedstatus |
      | nikita.kature | Welcome123 | success        |




