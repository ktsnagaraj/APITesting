
@APItest
Feature: Trigger GET and POST 
  
  Scenario: Verify the response code for GET and POST
    Given the URL to perform API Testing
    When trigger the GET request
    And trigger the POST request
    Then valid status code received as response