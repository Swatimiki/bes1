Feature: Nominating the Revision To Preferred Status

  Scenario Outline: Estimate page functionality
    Given Login page
    When Enter username "<username>" and password "<Password>"
    And Click on the login button
    Then Logged in based on "<expectedstatus>"
    Then User navigates to NominateRevisions section


    Examples:
      | username       | Password | expectedstatus |
      | nikita.kature | Welcome123 | success        |

