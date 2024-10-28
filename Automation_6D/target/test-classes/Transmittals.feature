#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Run
Feature: Submittals creation Module in Share

  Scenario: This feature aims to test and create the Transmittals functionality within the application.
    Given I visit the User Login using sheetname "Credentials" and rownumber 0
    Then I enter the credentials and click a login button

  @Run
  Scenario: Verify the user is creating the Transmittals
    Given Click on the projectname using the sheetname "Transmittals" and rownumber 0
    And Navigate to the Project dashboard screen
    And Navigate to Transmittals in the Share Module
    Then Click Add button in the screen

  @Run
  Scenario: Verify entering valid Transmittals details
    And Enable or disable the toggle button using the sheetname "Transmittals" and rownumber 0

  @Run
  Scenario: Verify entering valid code
    When Clear the default code in the Transmittalcode field
    Then Enter the Transmittalcode using the sheetname "Transmittals" and rownumber 0

  @Run
  Scenario: Verify entering valid name
    And Enter the Transmittalname using the sheetname "Transmittals" and rownumber 0
    
     @Run
  Scenario: Verify entering valid Description
    Then Enter the Descriptions of transmittal using the sheetname "Transmittals" and rownumber 0
    
    @Run
  Scenario: Verify selecting valid Workflow 
    Then Select the Workflow for transmittal dropdown using the sheetname "Transmittals" and rownumber 0
    
     @Run
  Scenario: Verify Attaching files in the Attach files option
    Then Attach the file by the filename using the sheetname "Transmittals" and rownumber 0
    
      @Run
  Scenario: Verify click the create button
    Given Click the create button in the screen
    Then Transmittals should be created