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
Feature: Form creation Module in Attachments

  Scenario: This feature aims to test and create the Form functionality within the application.
    Given I visit the User Login using sheetname "Credentials" and rownumber 0
    Then I enter the credentials and click a login button

 @Run
  Scenario: Verify the user is creating the Daily Report
    Given Click projectname using the sheetname "Form" and rownumber 0
    And Route to the Project dashboard
    And Route to Form in the Attachments Module
    And Select the report in the FORMS using the sheetname "Form" and rownumber 0
    Then Click the Add button on the screen 
    
    @Run
    Scenario: Verify entering from date
    Then Enter the from date using the sheetname "Form" and rownumber 0
    
       @Run
    Scenario: Verify entering due date
    Then Enter the due date using the sheetname "Form" and rownumber 0
    
      @Run
    Scenario: Verify entering location
    Then Enter the locationname using the sheetname "Form" and rownumber 0
    
      @Run
    Scenario: Verify selecting workflow
    Then select workflowname using the sheetname "Form" and rownumber 0
    
      @Run
    Scenario: Verify entering description
    Then Enter description using the sheetname "Form" and rownumber 0
    
      @Run
    Scenario: Verify user click the Add work button
    Then Click Add Work button
    
      @Run
    Scenario: Verify entering add work details
    Then Enter work details using the sheetname "Form" and rownumber 0
    
      @Run
    Scenario: Verify user click the save button in work pop up
    Then Click Save button to save work details
    
       @Run
    Scenario: Verify user click the Add Material button
    Then Click Add Material button
    
      @Run
    Scenario: Verify entering add material details
    Then Enter material details using the sheetname "Form" and rownumber 0
    
      @Run
    Scenario: Verify user click the save button in material popup
    Then Click Save button to save material details
    
      @Run
    Scenario: Verify user click the Add Equipment button
    Then Click Add Equipment button
    
      @Run
    Scenario: Verify entering add Equipment details
    Then Enter Equipment details using the sheetname "Form" and rownumber 0
    
      @Run
    Scenario: Verify user click the save button in Equipment popup
    Then Click Save button to save Equipment details
    
    @Run
    Scenario: Verify user entering Notes 
    Then Enter Notes using the sheetname "Form" and rownumber 0
    
    @Run
    Scenario: Verify user created form
    Then click the create button 
    
   
    
     