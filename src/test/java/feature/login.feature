Feature: Login to Adactin

  Scenario: Successful login
    Given User launches the adactin hotel booking site
    When User enters the login username "username" and password "password"
    And User clicks the login button
    Then User Should be navigated to the Search Hotel page

  Scenario: user Searching for Hotel
    Given User navigated to search hotel page after Login
    When   User choose and select the Location of Hotel
    And User choose the Hotel
    And User Select the type of room
    And User Select the No. of rooms
    And User choose the check in date
    And User choose the check out date
    And User select the No.of adults per room
    And User select the No.of children per room
    And User clicks the search button
    Then User Should be navigated to the Booked Itinerary
