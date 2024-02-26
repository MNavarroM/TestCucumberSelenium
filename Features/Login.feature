Feature: Login 

Background:
Given The user on login page


Scenario: Successful Login 
When The user enter the valid credentials
Then The user was redirected to the home page			

Scenario: Unsuccessful Login 
When The user enter the incorrect credentials
Then The login page show a error message			

Scenario: Blocked user
When The user enter the blocked credentials
Then The login page show a error block message	
