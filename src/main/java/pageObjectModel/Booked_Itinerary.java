package pageObjectModel;

import Baseclass.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Booked_Itinerary extends BaseClass {

    private WebDriver driver;

    //constructor

    public Booked_Itinerary(WebDriver driver){
        this.driver = driver;
    }

    //Locators

    private final String check_All_Button = "//input[@id='check_all']";
    private final String cancel_Selected_Button = "//input[@value='Cancel Selected']";
    private final String logout_Button = "//input[@value='Logout']";

    //getters

    public WebElement getCheck_All_Button() {
        return driver.findElement(By.xpath(check_All_Button));
    }
    public WebElement getCancel_Selected_Button() {
        return driver.findElement(By.xpath(cancel_Selected_Button));
    }
    public WebElement getLogout_Button() {
        return driver.findElement(By.xpath(logout_Button));
    }

    //setters
    public void setCheck_All_Button() {
        clickElement(check_All_Button);
    }
    public void setCancel_Selected_Button() {
        clickElement(cancel_Selected_Button);
    }

    public void confirmAlert( ) {
        handleAlert(true, null);
    }

    public void setLogout_Button() {
        clickElement(logout_Button);
    }
}
