Feature: Validate Login Functionality

This feature validates the login functionality of grabone website

Scenario: Login with valid credentials
Given I am in grabone website
When I logged in using valid username and password
Then I should verify successful login