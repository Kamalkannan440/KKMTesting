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
Feature: RFA creation Module in Actions

  Scenario: This feature aims to test and create the RFA functionality within the application.
    Given I visit the User Login using sheetname "Credentials" and rownumber 0
    Then I enter the credentials and click a login button

  @Run
  Scenario: Verify the user is creating the RFA
    Given Select projectname using the sheetname "RFA" and rownumber 0
    And Navigate to the Project dashboard
    And Navigate to RFA in the Action Module
    Then Click the Add button in the screen

  @Run
  Scenario: Verify entering valid RFA code
    When Clear the default code in the RFAcode field
    Then Enter the RFA code using the sheetname "RFA" and rownumber 0

  @Run
  Scenario: Verify entering valid RFA name field
    And Enter the RFA name using the sheetname "RFA" and rownumber 0

  @Run
  Scenario: Verify entering valid RFA Description field
    And Enter the RFA Description using the sheetname "RFA" and rownumber 0

  @Run
  Scenario: Verify entering valid Start Date field
    And Enter the Start Date using the sheetname "RFA" and rownumber 0

  @Run
  Scenario: Verify entering valid End Date field
    Then Enter the End Date using the sheetname "RFA" and rownumber 0

  @Run
  Scenario: Verify selecting valid Workflow field from the dropdown
    Then Select Workflow from the dropdown using the sheetname "RFA" and rownumber 0

  @Run
  Scenario: Verify selecting valid Priority field from the dropdown
    Then Select Priority from the dropdown using the sheetname "RFA" and rownumber 0

  @Run
  Scenario: Verify selecting valid checklist field from the dropdown
    Then Select checklist dropdown using the sheetname "RFA" and rownumber 0

  @Run
  Scenario: Verify Attaching files in the Attach files
    Then Attach file from drive the file name using the sheetname "RFA" and rownumber 0

  @Run
  Scenario: Verify click the create button
    Given Click the create button
    Then RFA should be created
