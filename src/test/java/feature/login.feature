Feature: Login to Adactin

  Scenario: Successful login
    Given User launches the adactin hotel booking site
    When User enters the login username "username" and password "password"
    And User clicks the login button
    Then User Should be navigated to the Search Hotel page
