Feature: Homepage to Sign-Up

  Background:
    Given I am at the Homepage
    And Click the X button
    When I will click the Sign-Up page
    Then Should be at Sign-Up page and Click the Email section

  Scenario Outline:
    Given I enter "<email>" a non-registered email account and enter a "<password>" password
    And Click the hidden eye button
    And I Click the check box agreement
    When I click the Sign-Up Button
    Then The Gee-Test prompt will show
    And The Security Verification prompt will show
    And The Confirm Button will click after entering the code

    Examples:
      | email                     | password     |
      | lorenzburat11@yopmail.com | Admin@123456 |
