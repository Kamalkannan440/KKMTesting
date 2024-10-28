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
Feature: RFI creation Module in Actions

  Scenario: This feature aims to test and create the Role functionality within the application.
    Given I visit the User Login using sheetname "Credentials" and rownumber 0
    Then I enter the credentials and click a login button

  @Run
  Scenario: Verify the user is creating the RFI
    Given Select the projectname using the sheetname "RFI" and rownumber 0
    And Navigate to Project dashboard
    And Navigate to RFI in the Action Module
    Then Click the Add button

  @Run
  Scenario: Verify entering valid RFI details
    And Click the toggle button using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify entering valid RFI code
    When Clear the default code in the RFIcode field
    Then Enter the RFI code using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify entering valid RFI name field
    And Enter the RFI name using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify entering valid RFI Question field
    And Enter the RFI Question using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify entering valid Suggested answer field
    And Enter the Answer using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify entering valid Due Date field
    Then Enter the Due Date using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify entering valid Location field
    Then Enter the Location using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify selecting  valid Type field from the dropdown
    Then Select Type dropdown using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify selecting valid Discipline field from the dropdown
    Then Select Discipline dropdown using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify selecting valid Category field from the dropdown
    Then Select Category dropdown using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify selecting valid Workflow field from the dropdown
    Then Select Workflow dropdown using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify selecting valid Priority field from the dropdown
    Then Select Priority dropdown using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify Uploading image in the Upload photos/images field
    Then Upload image from the image path using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify Attaching files in the Attach files
    Then Attach the file name using the sheetname "RFI" and rownumber 0

  @Run
  Scenario: Verify click the create button
    Given Click the create button
    Then RFI should be created
