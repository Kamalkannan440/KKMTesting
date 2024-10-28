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
##@Documentupload
@Run
 Scenario: Verify the user is able to upload the documents
 Given Select the projectname using sheetname "Document" and rownumber 0
 And Navigate to project dashboard
 And Click the Upload files button
 And Upload the documents using sheet "Document" and rownumber 0 fecthing the document path from excel
 Then Document should be uploaded
 