@tag
Feature: Admin login 
  I want to use this template check admin login with invalid inputs

  @tag2
  Scenario: check admin login with invalid inputs
    Given i open browser with url "http://webapp.qedgetech.com/"
    Then i see login page
    When i enter user a "<uid>"
    And i enter password as "<pwd>"
    And i click login
     And clik on alert
    And i close browser
    
    
        Examples: 
      | uid  | pwd | 
      | admin |    5 | 
      |  |master |
      |a|m|
      |admin|aster|