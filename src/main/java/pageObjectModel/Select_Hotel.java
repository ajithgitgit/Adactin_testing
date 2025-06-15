package pageObjectModel;

import Baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Select_Hotel extends BaseClass {
    private WebDriver driver;

    //constructor

    public Select_Hotel(WebDriver driver) {
        this.driver = driver;
    }
    //locators

    private final String selectHotel ="//input[@id='radiobutton_0']";
    private  final String continueButton = "//input[@id='continue']";

    //getter


    public WebElement getSelectHotel() {
        return driver.findElement(By.xpath(selectHotel));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.xpath(continueButton));
    }
    //setter

    public void setSelectHotel() {

        getSelectHotel().click();
    }
    public void setContinueButton() {

        getContinueButton().click();
    }
}
