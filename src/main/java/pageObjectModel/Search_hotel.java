package pageObjectModel;
import Baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Search_hotel extends  BaseClass{
    private WebDriver driver;

    //constructor
    public Search_hotel(WebDriver driver) {
        this.driver = driver;
    }
    //locators
    private final String hotelLocation ="//select[@id='location']";
    private final String hotelName = "//select[@id='hotels']";
    private final String roomType = "//select[@id='room_type']";
    private final String numberOfRooms = "//select[@id='room_nos']";
    private final String checkInDate = "//input[@id='datepick_in']";
    private final String checkOutDate = "//input[@id='datepick_out']";
    private final String adultsPerRoom = "//select[@id='adult_room']";
    private final String childrenPerRoom = "//select[@id='child_room']";
    private final String search_Button = "//input[@id='Submit']";



    //getters

     public WebElement getHotelLocation() {
         return driver.findElement(By.xpath(hotelLocation));
     }

     public WebElement getHotelName() {
         return driver.findElement(By.xpath(hotelName));

     }
    public WebElement getRoomType() {
        return driver.findElement(By.xpath(roomType));
    }

    public WebElement getNumberOfRooms() {
        return driver.findElement(By.xpath(numberOfRooms));

    }
    public WebElement getCheckInDate() {
        return driver.findElement(By.xpath(checkInDate));
    }

    public WebElement getCheckOutDate() {
        return driver.findElement(By.xpath(checkOutDate));

    }
    public WebElement getAdultsPerRoom() {
        return driver.findElement(By.xpath(adultsPerRoom));
    }

    public WebElement getChildrenPerRooms() {
        return driver.findElement(By.xpath(childrenPerRoom));

    }
    public WebElement getSearch_Button() {
        return driver.findElement(By.xpath(search_Button));
    }
//    //setters
     public void  setHotelLocation(String Text) {
         waitForVisibility(hotelLocation, 10);
         selectDropdown(hotelLocation, "visible text", Text);
     }
    public void  setHotelName(String Text) {
        waitForVisibility(hotelName, 10);
        selectDropdown(hotelName, "index", Text);
    }
    public void  setRoomType(String Text) {
        waitForVisibility(roomType, 10);
        selectDropdown(roomType, "value", Text);
    }
    public void  setNumberOfRooms(String Text) {
        waitForVisibility(numberOfRooms, 10);
        selectDropdown(numberOfRooms, "index", Text);
    }
    public void  setCheckInDate(String Text) {
        waitForVisibility(checkInDate, 10);
        entertext(checkInDate,Text);
    }
    public void  setCheckOutDate(String Text) {
        waitForVisibility(checkOutDate, 10);
        entertext(checkOutDate,Text);
    }
    public void  setAdultsPerRoom(String Text) {
        waitForVisibility(adultsPerRoom, 10);
        selectDropdown(adultsPerRoom, "index", Text);
    }
    public void setChildrenPerRoom(String Text) {
        waitForVisibility(childrenPerRoom, 10);
        selectDropdown(childrenPerRoom, "index", Text);
    }
    public void setSearch_Button() {
         getSearch_Button().click();


    }

}
