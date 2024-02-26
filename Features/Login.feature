Feature: Login 

Background:
Given The user on login page


Scenario: Successful Login 
When The user enter standard_user as user and secret_sauce as password
Then The user was redirected to the home page			

Scenario: Unsuccessful Login
When The user enter standard_user as user and password as password
Then The login page show a error message			

Scenario: Blocked user
When The user enter locked_out_user as user and secret_sauce as password
Then The login page show a error block message	
