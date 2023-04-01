
Feature: Register Functionality
  User should register Application
Background:
Given user nevigate to regiter account page
  @tag11
  Scenario: Register with mendetory field
    Given user nevigate to regiter account page
    And enter the user info details into below field
      | firstname        | komal                    |
      | lastname         | dhale                    |
      | emailid          | komal.dhale111@gmail.com |
      | telephone        |               1234567890 |
      | password         |                   123456 |
      | confirm password |                   123456 |
    And select privacy policy
    And click on contineue buton
    Then account should successfully created

  @tag11
  Scenario: Register with mendetory field
    And enter the users info details into below field
      | firstname | lastname | emailid         | telephone  | password | confirm password |
      | kivi1      | viki1    | kivi11@gamil.com | 1234567890 |     1234 |             1234 |
      | kivi11     | viki2    | kivi112@gamil.com | 1234567890 |    12341 |            12341 |
      | kivi21    | viki3    | kivi13@gamil.com | 1234567890 |    12342 |            12342 |
      | kivi1    | viki4    | kivi14@gamil.com | 1234567890 |    12343 |            12343 |
    And select privacy policy
    And click on contineue buton
    Then account should successfully created
  #Scenario: Register with all field
    #Given user nevigate to regiter account page
    #And enter the user info details into below field
      #| firstname        | "abc"          |
      #| lastname         | "pqr                 |
      #| emailid          | "komal1dhale1@gmail.com" |
      #| telephone        | "1234561890"             |
      #| password         | "1234561                 |
      #| confirm password | "1234561                 |
     #And select yes for newsletter
    #And select privacy policy
    #And click on contineue buton
    #Then account should successfully created
#
  #Scenario: Register with empty field
    #Given user nevigate to regiter account page
    #When user should not fill all mendetory field
    #
    #And click on contineue button
    #Then warning massage should display for all mendetory field
#
  #Scenario: Register with duplicate field
    #Given user nevigate to regiter account page
     #| firstname        | "komal"                  |
      #| lastname         | "dhale"                  |
      #| emailid          | "komal.dhale1@gmail.com" |
      #| telephone        | "1234567890"             |
      #| password         | "123456"                 |
      #| confirm password | "123456"                 |
   #And enter the user info details into below field
   #
    #And select privacy policy
    #And click on contineue buton
    #Then warning massage should display for duplicate field
