package com.pageObjectModel;

import com.Baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BaseClass {

    private WebDriver driver;

    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // XPath locators (String-based for BaseClass compatibility)
    private final String hotelLocationXPath = "//select[@name='location']";

    // Getter for WebElement
    public WebElement getHotelLocation() {
        return driver.findElement(By.xpath(hotelLocationXPath));
    }

    // Setter (actually performs action, not a traditional setter)
    public void setHotelLocation(String Text) {
        waitForVisibility(hotelLocationXPath, 10);
        selectDropdown(hotelLocationXPath, "visibleText", Text);
    }
}
