Feature: Sign Up
  Scenario: Sign up as a new User
Feature: Login
  Scenario Outline: Login as a valid user
    Given User launches the browser
    When user opens the URL "https://test.chaka.ng/"
    And clicks on Sign Up
    When User enters email as "<email>" and password as "<password>" and confirmed password "<password>"
    And clicks on Sign up button
    Then close browser


    Examples:
    |email|password|password|
    |uche.c.emeka@gmail.com|Z1ebra|Ze1bra|
