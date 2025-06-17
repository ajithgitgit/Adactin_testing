package pageObjectModel;

import Baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Booking_Confirmation extends BaseClass {
    private WebDriver driver;

    //constructor

    public Booking_Confirmation(WebDriver driver){
        this.driver = driver;
    }

    //locators

    private final String my_Itinerary_Button = "//input[@id='my_itinerary']";

    //getters

    public WebElement getMy_Itinerary_Button() {
        return driver.findElement(By.xpath(my_Itinerary_Button));

    }

    //action

    public void setMy_Itinerary_Button() {
        waitForVisibility(my_Itinerary_Button, 10);
        clickElement(my_Itinerary_Button);
    }
}
