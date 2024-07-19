
    
    
    

    


@tag
Feature: Adding item 
  I want to use this template  adding item stcok account page

  @tag3
  Scenario: check admin login with valid inputs and  adding stcok_item module
    Given i open browser with url "http://webapp.qedgetech.com/"
    Then i see login page
    When i enter user a "admin"
    And i enter password as "master"
    And i click login
    Then i see Dashboard
    Then i click on Stock item 
    And i click plus button
    Then i should enter all mondary feilds as "kia","23","240","hello"
    And i click add button
    And click ok button on confim page
    Then click ok button on alert
    And i click on Search button and paste the value on Search bar 
    And click Search button
    Then check the item is displayed or not 
    And i click logout
    Then i close browser
    
  
    
    

 