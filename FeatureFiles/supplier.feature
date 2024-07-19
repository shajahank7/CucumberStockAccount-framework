    
  @tag
Feature: supplier module
    @tag4
    Scenario: check  supplier module
    Given i open browser with url "http://webapp.qedgetech.com/"
    Then i see login page
    When i enter user a "admin"
    And i enter password as "master"
    And i click login
    Then i see Dashboard
    Then i click on supplier link
    And i click plus button
    Then fill all mandtry fileds in the supplier page as "54321","DMM","dharmavaram","india","raju","9876543213","test@gamil.com","9878653532","ok"                    
    And i click add button
    And click ok button on confim page
    Then click ok button on alert
    And i click on Search button and paste the value on Search bar in supplier module
    And click Search button
    Then check the item is displayed or not in supplier module
    And i click logout
    Then i close browser