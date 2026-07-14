Feature: Login functionality

  Scenario Outline: Successful login with valid credentials
   Given Login page
    When Enter username "<username>" and password "<Password>"
    And Click on the login button
    Then Logged in based on "<expectedstatus>"

   Examples:
     | username       | Password    | expectedstatus |
     | meenal.singhal | singmeen    | success        |
     | nikita.kature  | Welcome@123 | failure         |
