package com.stepdefinition;

import com.Baseclass.BaseClass;
import com.pageObjectModel.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class loginSteps extends BaseClass {

    WebDriver driver;
    protected LoginPage loginPage;

    @Given("User launches the adactin hotel booking site")
    public void user_launches_the_adactin_hotel_booking_site() {
        driver = launchBrowser("firefox");
        openUrl("https://adactinhotelapp.com");
        loginPage = new LoginPage(driver); // Initialize page object
    }

    @When("User enters the login username {string} and password {string}")
    public void user_enters_the_login_username_and_password(String username, String password) {
        loginPage.enterUsername("ajith976");
        loginPage.enterPassword("user1234");
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.clickLoginButton();
        System.out.println("Login button clicked successfully.");
        takeScreenshot("succesfull");

    }

    @Then("User Should be navigated to the Search Hotel page")
    public void user_should_be_navigated_to_the_search_hotel_page() {
        String actualTitle = getTitle();
        Assert.assertTrue(actualTitle.contains("Search Hotel"), "Page title doesn't contain 'Search Hotel'");
        closeBrowser();
    }
}
