@SmokeTest @RegressionTest @LogInTest
Feature: Test LogIn Functionalities
BackGround:
Given a user is on the Login Page

@positive_test
Scenario: Check login is successful with valid credentials
  When user enters username "Shafin" and password "12345"
  And click on login button
  Then user is Navigated to home page

@negative_test
Scenario: Check login is unsuccessful with invalid credentials
  When user enters username "Shafin" and password "44444"
  And click on login button
  Then user is failed to login

@dataDriven_test
Scenario Outline: Check login is successful with valid credentials for multiple users
  When user enters username "<username>" and password "<password>"
  And click on login Button
  Then user is navigated to login

  Examples:
  |username|password|
  |Rifat   |12345   |
  |Robert  |12345   |
  |Edward  |12345   |

@datatable_test
Scenario: Check login is successful using data table
  When user click on login button upon entering credentials
  |username|password|
  |Rifat   |12345   |
  Then user is navigated to home page
