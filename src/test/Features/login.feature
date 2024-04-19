Feature: Login Page Automation

Scenario: User is able to login with valid credentials
Given User is on login page
When User enters valid username and password
And User clicks on login button
Then User is navigated to home page
And Close the browser