Feature:LoginFunctionality

  As a user of openCart website
  I want to login with my account
  So that I can access my account related feature and manage my orders

  Background:
  Given I am the opencart login page

  Scenario: Sucessfull login with valid credentials
  Given I have entered valid username and password
  When I click on login page
  Then I should be login successfully

  Scenario Outline:UnSucessfull login with invalid or empty credentials
   Given I have Entered invalid "<username>" and "<password>"
   When I click on login button
   Then I could se error message indicating "<error message>"


    Examples:
      | username          | password | error message |
      | dipi257@gmail.com | papa25!@ | Warning: No match for E-Mail Address and/or Password. |
      | dipi257@gmail.com | papa2555 | Warning: No match for E-Mail Address and/or Password. |
      | dipi257@gmail.com | papa2536 | Warning: No match for E-Mail Address and/or Password. |

  Scenario: Navigating to the forgotten password page
    Given click on the "forgotten password" link
    Then I Should be redirected to the password reset page








