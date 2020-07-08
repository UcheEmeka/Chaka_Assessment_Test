Feature: Login
  Scenario: Login as a valid user
    Given User launches the browser
    When user opens the URL "https://test.chaka.ng/"
    And clicks on Login
    When User enters Email as "uche.c.emeka@gmail.com" and Password as "zebra"
    And Clicks on Login button
