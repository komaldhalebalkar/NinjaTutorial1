
@tag
Feature: Search functionality
  user should search the product 
Background: 
Given user nevigate to search page
  @tag1
  Scenario: user search the valid product
       When user enter the valid product into search field
    And user click on search button
    Then valid product should display on screen
    
 Scenario: user search the non existing product
        When user enter the non existing product into search field
    And user click on search button
    Then proper text massage product not available should display on screen
    
   Scenario: user search without providing any product
       When user does not enter any product into search field
    And user click on search button
    Then proper text massage product not available should display on screen
    