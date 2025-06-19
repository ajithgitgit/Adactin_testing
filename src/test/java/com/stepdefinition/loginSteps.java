package com.stepdefinition;

import Baseclass.BaseClass;
import Utils.ConfigReader;
import Utils.ExcelUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pageObjectModel.*;

public class loginSteps extends BaseClass {

    protected LoginPage loginPage;
    protected Search_hotel searchHotel;
    protected Select_Hotel select_hotel;
    protected BookHotel bookHotel;
    protected Booking_Confirmation bookingConfirmation;
    protected Booked_Itinerary bookedItinerary;


    @Given("User launches the adactin hotel booking site")
    public void user_launches_the_adactin_hotel_booking_site() {
       String browser  = ConfigReader.get("browser");
       driver = BrowserLaunch(browser);
       String url = ConfigReader.get("url");
       openUrl(url);
        searchHotel = new Search_hotel(driver);
        select_hotel = new Select_Hotel(driver);
        bookHotel = new BookHotel(driver);
        loginPage = new LoginPage(driver);
        bookingConfirmation = new Booking_Confirmation(driver);
        bookedItinerary = new Booked_Itinerary(driver);

    }

    @When("User enters the login username {string} and password {string}")
    public void user_enters_the_login_username_and_password(String username, String password) throws Exception {

        String username1 = ExcelUtils.getUserName("src/test/java/Utils/Test1.xlsx", "test1");
        loginPage.enterUsername(username1);
        String password1 = ExcelUtils.getPassword("src/test/java/Utils/Test1.xlsx", "test1");
        loginPage.enterPassword(password1);
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        clickElement("//input[@id='login']");
        System.out.println("Login Button clicked successfully");
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
      searchHotel.setHotelName("1");
    }
    @Then("User select the type of room and number of rooms")
    public void user_select_the_type_of_room_and_number_of_rooms() {
        searchHotel.setRoomType("Double");
        searchHotel.setNumberOfRooms("3");
    }
    @Then("User choose the check in date and check out date")
    public void user_choose_the_check_in_date_and_check_out_date() {
        searchHotel.setCheckInDate("14/06/2025");
        searchHotel.setCheckOutDate("15/06/2025");
    }
    @Then("User select the number of adults per room and children per room")
    public void user_select_the_number_of_adults_per_room_and_children_per_room() {
        searchHotel.setAdultsPerRoom("3");
        searchHotel.setChildrenPerRoom("2");
    }
    @Then("User clicks the search button")
    public void user_clicks_the_search_button() {
        searchHotel.setSearch_Button();
        System.out.println(driver.getTitle());
    }
    @Then("user click the select and continue button to confirm the Hotel")
    public void user_click_the_select_and_continue_button_to_confirm_the_hotel() {
        select_hotel.setSelectHotel();
        select_hotel.setContinueButton();
    }
    @Then("user navigated to Book A Hotel page")
    public void user_navigated_to_book_a_hotel_page() {
        bookHotel.getTitle();
    }
    @Then("user enters the First Name")
    public void user_enters_the_first_name() {
        bookHotel.setFirstName("Hussaini");
    }
    @Then("user enters the Last Name")
    public void user_enters_the_last_name() {
        bookHotel.setLastName("Mubarak");
    }
    @Then("user enters the Billing Address")
    public void user_enters_the_billing_address() {
        bookHotel.setBillingAddress("chennai");
    }
    @Then("user enters the Credit Card Number")
    public void user_enters_the_credit_card_number() {
        bookHotel.setCreditCardNumber("1234567890123456");
    }
    @Then("user selects the Credit Card type")
    public void user_selects_the_credit_card_type() {
        bookHotel.setCreditCardType("3");
    }
    @Then("user selects the Expiry month and year")
    public void user_selects_the_expiry_month_and_year() {
       bookHotel.setExpiryMonth("3");
       bookHotel.setExpiryYear("2026");
    }
    @Then("User Enters the Cvv number")
    public void user_enters_the_cvv_number() {
        bookHotel.setCvv("123");
    }
    @Then("user click the Book now button")
    public void user_click_the_book_now_button() throws InterruptedException {
       bookHotel.setBookNowButton();
    }


    @And("user clicks my Itinerary Button")
    public void userClicksMyItineraryButton() {
        bookingConfirmation.setMy_Itinerary_Button();


    }

    @And("user should be navigated to Booking itinerary Page")
    public void userShouldBeNavigatedToBookingItineraryPage() {
        System.out.println(bookedItinerary.getTitle());

    }

    @And("user click check all radio button")
    public void userClickCheckAllRadioButton() {
        bookedItinerary.setCheck_All_Button();
    }

    @And("User clicks cancel selected button")
    public void userClicksCancelSelectedButton() {
        bookedItinerary.setCancel_Selected_Button();

    }
    @And("user confirms the  alert")
    public void userConfirmsTheAlert() {
        driver.switchTo().alert();
        bookedItinerary.confirmAlert();
    }

    @And("User click logout Button")
    public void userClickLogoutButton() {
        bookedItinerary.setLogout_Button();
        System.out.println(bookedItinerary.getTitle());
    }


}
