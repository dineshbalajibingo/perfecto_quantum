@smoke
	Feature: Test FifthThird App login and Location
	
 @smoke
  Scenario: Validating invalid user name and password error message
    Given I start the application by the name "Fifth Third"
    When I enter "PerfectoMOBTest" and "Test@1234"
    And I click on login button
    Then I get an error message "Test Error1"
