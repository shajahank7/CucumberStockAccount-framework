
@tag
Feature: Admin login 
  I want to use this template check admin login

  @tag1
  Scenario: check admin login with valid inputs
    Given i open browser with url "http://webapp.qedgetech.com/"
    Then i see login page
    When i enter user a "admin"
    And i enter password as "master"
    And i click login
    Then i see Dashboard
    When i click logout
    Then i see login page
    And i close browser
    
   
    
    
    

 