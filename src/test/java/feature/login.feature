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
    Then user click the select and continue button to confirm the Hotel
    And user navigated to Book A Hotel page
    And user enters the First Name
    And user enters the Last Name
    And user enters the Billing Address
    And user enters the Credit Card Number
    And user selects the Credit Card type
    And user selects the Expiry month and year
    And User Enters the Cvv number
    And user click the Book now button
    And user clicks my Itinerary Button
    And user should be navigated to Booking itinerary Page
    And user click check all radio button
    And User clicks cancel selected button
    And user confirms the  alert
    And User click logout Button


