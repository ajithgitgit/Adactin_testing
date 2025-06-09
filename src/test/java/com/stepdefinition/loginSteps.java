package com.stepdefinition;
import Baseclass.BaseClass;
import org.junit.Assert;
import pageObjectModel.LoginPage;
import pageObjectModel.Search_hotel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import pageObjectModel.Search_hotel;

import static org.jsoup.select.Selector.select;
import static org.openqa.selenium.devtools.v123.fedcm.FedCm.openUrl;

public class loginSteps extends BaseClass {

    WebDriver driver;
    protected LoginPage loginPage;
    protected Search_hotel searchHotel;


    @Given("User launches the adactin hotel booking site")
    public void user_launches_the_adactin_hotel_booking_site() {

        BrowserLaunch("edge");
        openUrl("https://adactinhotelapp.com");

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


    @When("User choose and select the Location of Hotel")
    public void user_choose_and_select_the_location_of_hotel() {

    }
}
//    @When("User choose the Hotel")
//    public void user_choose_the_hotel() {
//        WebElement hotel = driver.findElement(By.id("hotels"));
//        Select s2= new Select(hotel);
//        s2.selectByIndex(3);
//
//    }
//    @When("User Select the type of room")
//    public void user_select_the_type_of_room() {
//        WebElement roomType = driver.findElement(By.id("room_type"));
//        Select s3 = new Select(roomType);
//        s3.selectByIndex(2);
//
//    }
//    @When("User Select the No. of rooms")
//    public void user_select_the_no_of_rooms() {
//        WebElement nos_Room = driver.findElement(By.id("room_nos"));
//        Select s4 = new Select(nos_Room);
//        s4.selectByIndex(2);
//
//    }
//    @When("User choose the check in date")
//    public void user_choose_the_check_in_date() {
//        driver.findElement(By.id("datepick_in")).sendKeys("06/06/2025");
//
//    }
//    @When("User choose the check out date")
//    public void user_choose_the_check_out_date() {
//        driver.findElement(By.id("datepick_out")).sendKeys("08/06/2025");
//
//    }
//    @When("User select the No.of adults per room")
//    public void user_select_the_no_of_adults_per_room() {
//        WebElement adults_Per_Room = driver.findElement(By.id("adult_room"));
//        Select s5 = new Select(adults_Per_Room);
//        s5.selectByIndex(4);
//
//    }
//    @When("User select the No.of children per room")
//    public void user_select_the_no_of_children_per_room() {
//        WebElement childrens_Per_Room = driver.findElement(By.id("child_room"));
//        Select s6 = new Select(childrens_Per_Room);
//        s6.selectByIndex(1);
//
//    }
//    @When("User clicks the search button")
//    public void user_clicks_the_search_button() {
//        driver.findElement(By.id("Submit")).click();
//
//    }
//    @Then("User Should be navigated to the Booked Itinerary")
//    public void user_should_be_navigated_to_the_booked_itinerary() {
//        WebElement BookedItinerary =  driver.findElement(By.xpath("//a[text()='Booked Itinerary']"));
//        String tab = Keys.chord(Keys.CONTROL,Keys.RETURN);
//       BookedItinerary.sendKeys(tab);
//    }
//
//}
