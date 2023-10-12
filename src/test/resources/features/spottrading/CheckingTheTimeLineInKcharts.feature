Feature: Checking the Timeframes

  //needs to login first before checking the Time frames
  Background:
    Given I am at the Homepage
    And Click the X button
    When I will click the Login page

  Scenario Outline: Login using registered account
    Given I enter a valid "<email>" address and a valid "<password>"
    And Click the hidden eye button
    When I will click the Login button
    Then Gee-test will prompt

    Examples:
      | email                      | password         |
      | bibvip.mananabas@gmail.com | Admin@1234567890 |

  Scenario : Check the time frame of spot trading
    Given I am on the Spot page trading
    And I select a trading pair
    When I select the time frame
    Then I should see that the klines are displayed with the time frame

