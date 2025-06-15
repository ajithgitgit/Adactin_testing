package Baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public static WebDriverWait wait;

    // Launch browser with implicit wait
    public WebDriver BrowserLaunch(String browserType) {
        try {
            if (browserType.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browserType.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else if (browserType.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Invalid Browser type");
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        } catch (Exception e) {
            System.out.println("Browser launch failed " + e.getMessage());
        }
        return driver;
    }
    //open url method

    public  void  openUrl (String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            System.out.println("failed to open URL" + e.getMessage());
        }

    }

    //Enter The text

    public void entertext(String xpath, String text) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(text);

        } catch (Exception e) {
            System.out.println("Error entering text: " + e.getMessage());
        }
    }
    //click element
     public  void clickElement(String xpath){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            System.out.println("Error clicking element: " + e.getMessage());
        }
     }
    // Screenshot
    public void takeScreenshot(String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("src/test/screenshots/" + fileName + ".png"));
        } catch (IOException e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }
    public String getTitle() {
        try {
            return driver.getTitle();

        } catch (Exception e) {
            System.out.println("Failed to get title: " + e.getMessage());
        return  null;
    }
    }
    //DropDownSelection
    public void selectDropdown(String xpath, String type, String value) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Select select = new Select(element);

            switch (type.toLowerCase()){
                case "visible text":
                    select.selectByVisibleText(value);
                    break;
                case "index":
                    select.selectByIndex(Integer.parseInt(value));
                    break;
                case "value":
                    select.selectByValue(value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid select Type: " + type);
            }


        } catch (Exception e) {
            System.out.println("Dropdown Selection failed " + e.getMessage());
        }
    }
    // Explicit wait utility
    public void waitForVisibility(String xpath, int seconds) {
      try {
          WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
          customWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
      } catch (Exception e) {
          System.out.println("Wait For Visibility Failed " + e.getMessage());
      }

    }





}







