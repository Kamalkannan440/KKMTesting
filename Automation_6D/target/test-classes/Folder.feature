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
Feature: Role creation Module in Administration
Scenario: This feature aims to test and create the Role functionality within the application.

Given I visit the User Login using sheetname "Credentials" and rownumber 0
Then I enter the credentials and click a login button

##@Folder
@Run
Scenario: Verify the user is able to create the folder
 Given Select the projectname using sheetname "Folder" and rownumber 0
 And Navigate to project dashboard
 And User can create the new folder by foldername entered using the sheetname "Folder" and rownumber 0
 And New folder should be created
 And User can create the new subfolder by subfoldername entered using the sheetname "Folder" and rownumber 0
 