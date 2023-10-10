Feature: Homepage to Sign-Up

#  THIS Background, THE CODES STEP DEFINITIONS IS ON THE LoginStepsDefs.java
  Background:
    Given I am at the Homepage to click the Signup page
    And Exit the prompt ads
    When I will click the Sign-Up page
    Then Should be at Sign-Up page and Click the Email section

  Scenario Outline:
    Given I enter "<email>" a non-registered email account and enter a "<password>" password
    And Click the hidden eye button in signup
    And Enter optionally a Invitation Code
    And I Click the check box agreement
    When I click the Sign-Up Button
    And The Gee-Test prompt will show
    And The Security Verification prompt will show
    Then The Confirm Button will click after entering the code
    And The Send Notification prompt will displayed

    Examples:
      | email                     | password     |
      | lorenzburat11@yopmail.com | Admin@123456 |
