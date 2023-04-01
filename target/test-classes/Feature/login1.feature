
Feature: Login functionality using diff data
  ueser should login the Application

  @tag11
  Scenario: login with valid inputs
    Given user nevigate to application url
    When user enters the valid emailid and password 
      | email                  | pass   |
      | komalr.dhale@gmail.com | 123456 |
      | sachin1@gmail.com      | 234567 |
        And user click on login button
    Then user should login successfully

    