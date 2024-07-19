@tag
Feature: purchases module
  I want to use this template purchases module functionality

  @tag5
  Scenario: check admin login with valid inputs and  adding stcok_item module
    Given i open browser with url "http://webapp.qedgetech.com/"
    Then i see login page
    When i enter user a "admin"
    And i enter password as "master"
    And i click login
    Then i see Dashboard
    Then i click on Purchases link
    And i click plus button 
    Then i full all mondary feilds in purchase module
    And click ok button on confim page on purchases module
    And i click on Search button and paste the value on Search bar on purchases page
    And click Search button
    Then check the item is displayed or not on purchases page
    And i click logout
    Then i close browser
    