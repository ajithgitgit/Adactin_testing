package com.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class loginSteps {

    WebDriver driver;
    @Given("User launches the adactin hotel booking site")
    public void user_launches_the_adactin_hotel_booking_site() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://adactinhotelapp.com");
    }
    @When("User enters the login username {string} and password {string}")
    public void user_enters_the_login_username_and_password(String username, String password) {
        driver.findElement(By.id("username")).sendKeys("rograven");
        driver.findElement(By.id("password")).sendKeys("1223344");

        throw new io.cucumber.java.PendingException();
    }
    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        driver.findElement(By.id("login")).click();
        throw new io.cucumber.java.PendingException();
    }
    @Then("User Should be navigated to the Search Hotel page")
    public void user_should_be_navigated_to_the_search_hotel_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("is search the hotel")
    public void is_search_the_hotel() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
