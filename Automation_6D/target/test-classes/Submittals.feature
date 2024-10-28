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

  Scenario: This feature aims to test and create the Submittals functionality within the application.
    Given I visit the User Login using sheetname "Credentials" and rownumber 0
    Then I enter the credentials and click a login button

  @Run
  Scenario: Verify the user is creating the Submittals
    Given Click the projectname using the sheetname "Submittals" and rownumber 0
    And Navigate to Project dashboard screen
    And Navigate to Submittals in the Share Module
    Then Click Add button on the screen

  @Run
  Scenario: Verify entering valid Submittals details
    And Click toggle button using the sheetname "Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid code
    When Clear the default code in the Submittalcode field
    Then Enter the Submittalcode using the sheetname "Submittals" and rownumber 0

  @Run
  Scenario: Verify entering valid name
    And Enter the submittalname using the sheetname "Submittals" and rownumber 0
    
   @Run
  Scenario: Verify entering valid Spec Section
    And Select the Spec Section dropdown using the sheetname "Submittals" and rownumber 0
    
     @Run
  Scenario: Verify entering valid Sub Spec Section
    And Select the Sub Spec Section dropdown using the sheetname "Submittals" and rownumber 0
    
     @Run
  Scenario: Verify entering valid Description
    Then Enter the Descriptions using the sheetname "Submittals" and rownumber 0
    
    @Run
  Scenario: Verify selecting valid Type
    Then Select the Type dropdown using the sheetname "Submittals" and rownumber 0
    
     @Run
  Scenario: Verify selecting valid Workflow 
    Then Select the Workflow dropdown using the sheetname "Submittals" and rownumber 0
    
     @Run
  Scenario: Verify entering valid Due Date 
    Then Enter Due Date using the sheetname "Submittals" and rownumber 0
    
     @Run
  Scenario: Verify selecting valid Priority 
    Then Select the Priority dropdown using the sheetname "Submittals" and rownumber 0
    
    @Run
  Scenario: Verify entering valid Required Date 
    Then Enter Required Date using the sheetname "Submittals" and rownumber 0
    
     @Run
  Scenario: Verify entering valid Required approval Date 
    Then Enter Required approval Date using the sheetname "Submittals" and rownumber 0
    
     @Run
  Scenario: Verify entering valid Required on jobsite Date 
    Then Enter Required on jobsite Date using the sheetname "Submittals" and rownumber 0
    
    @Run
  Scenario: Verify entering valid Lead time
    Then Enter Lead time using the sheetname "Submittals" and rownumber 0

    @Run
  Scenario: Verify Attaching files in the Attach files
    Then Attach file name using the sheetname "Submittals" and rownumber 0
    
    
     @Run
  Scenario: Verify click the create button
    Given Click create button in the screen
    Then Submittals should be created