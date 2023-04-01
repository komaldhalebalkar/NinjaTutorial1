Feature: Login functionality
  ueser should login the Application

  @tag11
  Scenario Outline: login with valid inputs
    Given user nevigate to application url
    When user enters the valid emailid <email>
    And user enters the valid password <pass>
    And user click on login button
    Then user should login successfully

    Examples: 
      | email                  | pass   |
      | komalr.dhale@gmail.com | 123456 |
      | sachin1@gmail.com      | 234567 |
@tag1
  Scenario: login with invalid password and valid email
    Given user nevigate to application url
    When user enters the valid emailid "komalr.dhale@gmail.com"
    And user enters the invalid password "1234567"
    And user click on login button
    Then user should get proper warning massage
@tag11
  Scenario: login with invalid email and valid password
    Given user nevigate to application url
    When user enters the invalid emailid "komal.dhale12@gmail.com"
    And user enters the valid password "123456"
    And user click on login button
    Then user should get proper warning massage
@tag11
  Scenario: login with invalid email and invalid password
    Given user nevigate to application url
    When user enters the invalid emailid "komal.dhale12@gmail.com"
    And user enters the invalid password "1234567"
    And user click on login button
    Then user should get proper warning massage
@tag11
  Scenario: login with empty email and empty password
    Given user nevigate to application url
    When user enters the empty emailid " "
    And user enters the empty password " "
    And user click on login button
    Then user should get proper warning massage
