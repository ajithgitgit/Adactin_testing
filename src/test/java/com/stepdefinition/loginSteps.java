package com.stepdefinition;

import Baseclass.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pageObjectModel.LoginPage;
import pageObjectModel.Search_hotel;

public class loginSteps extends BaseClass {

    protected LoginPage loginPage;
    protected Search_hotel searchHotel;

    @Given("User launches the adactin hotel booking site")
    public void user_launches_the_adactin_hotel_booking_site() {
        BrowserLaunch("edge");
        openUrl("https://adactinhotelapp.com");
        searchHotel = new Search_hotel(driver);
        loginPage = new LoginPage(driver);
    }

    @When("User enters the login username {string} and password {string}")
    public void user_enters_the_login_username_and_password(String username, String password) {
        entertext("//input[@id='username']", "Hussain54");
        entertext("//input[@id='password']", "Hussain@65");
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        clickElement("//input[@id='login']");
        System.out.println("Login Button clicked successfully");
        takeScreenshot("login");
    }

    @Then("User Should be navigated to the Search Hotel page")
    public void user_should_be_navigated_to_the_search_hotel_page() {
        String actualTitle = getTitle();
        Assert.assertTrue("Page title doesn't contain 'Search Hotel'", actualTitle.contains("Search Hotel"));
    }

    @Then("User choose and select the Location of Hotel")
    public void user_choose_and_select_the_location_of_hotel() {
       searchHotel.setHotelLocation("London");

    }
    @Then("User select the Hotel")
    public void user_select_the_hotel() {
      searchHotel.setHotelName("2");
    }
    @Then("User select the type of room and number of rooms")
    public void user_select_the_type_of_room_and_number_of_rooms() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User choose the check in date and check out date")
    public void user_choose_the_check_in_date_and_check_out_date() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User select the number of adults per room and children per room")
    public void user_select_the_number_of_adults_per_room_and_children_per_room() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User clicks the search button")
    public void user_clicks_the_search_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User Should be navigated to the Booked Itinerary")
    public void user_should_be_navigated_to_the_booked_itinerary() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
