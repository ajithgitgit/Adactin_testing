package com.stepdefinition;

import Utils.ConfigReader;
import com.Baseclass.BaseClass;
import com.pageObjectModel.LoginPage;
import com.pageObjectModel.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class loginSteps extends BaseClass {

    private WebDriver driver;
    private LoginPage loginPage;
    private SearchPage searchPage;

    @Given("User launches the adactin hotel booking site")
    public void user_launches_the_adactin_hotel_booking_site() {
        // Use BaseClass's static driver getter
        this.driver = BaseClass.getDriver();

        // Initialize page objects with driver
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
    }

    @When("User enters the login username {string} and password {string}")
    public void user_enters_the_login_username_and_password(String username, String password) throws Exception {
        // Override parameters with values from config (optional)
        username = ConfigReader.get("username");
        password = ConfigReader.get("password");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.clickLoginButton();
        System.out.println("Login button clicked successfully.");
        takeScreenshot("login_successful");
    }

    @Then("User Should be navigated to the Search Hotel page")
    public void user_should_be_navigated_to_the_search_hotel_page() {
        String actualTitle = getTitle();
        Assert.assertTrue(actualTitle.contains("Search Hotel"), "Page title doesn't contain 'Search Hotel'");

        searchPage.setHotelLocation("London");
        takeScreenshot("search_page_loaded");
    }
}
