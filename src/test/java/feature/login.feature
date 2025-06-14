Feature: Login to Adactin

  Scenario: Successful login
    Given User launches the adactin hotel booking site
    When User enters the login username "username" and password "password"
    And User clicks the login button
    Then User Should be navigated to the Search Hotel page
    And User choose and select the Location of Hotel
    And User select the Hotel
    And User select the type of room and number of rooms
    And User choose the check in date and check out date
    And User select the number of adults per room and children per room
    And User clicks the search button
    Then User Should be navigated to the Booked Itinerary
