package com.Baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait wait;

    // Launch browser with implicit wait
    public WebDriver launchBrowser(String browserType) {
        try {
            if (browserType.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browserType.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Invalid browser type");
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // default explicit wait
        } catch (Exception e) {
            System.out.println("Browser launch failed: " + e.getMessage());
        }
        return driver;
    }

    // Open URL
    public void openUrl(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            System.out.println("Failed to open URL: " + e.getMessage());
        }
    }

    // Enter text
    public void enterText(String xpath, String text) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            System.out.println("Error entering text: " + e.getMessage());
        }
    }

    // Click element
    public void clickElement(String xpath) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            System.out.println("Error clicking element: " + e.getMessage());
        }
    }

    // Dropdown selection
    public void selectDropdown(String xpath, String type, String value) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Select select = new Select(element);

            switch (type.toLowerCase()) {
                case "visibletext":
                    select.selectByVisibleText(value);
                    break;
                case "value":
                    select.selectByValue(value);
                    break;
                case "index":
                    select.selectByIndex(Integer.parseInt(value));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid select type: " + type);
            }
        } catch (Exception e) {
            System.out.println("Dropdown selection failed: " + e.getMessage());
        }
    }

    // Mouse hover
    public void mouseHover(String xpath) {
        try {
            Actions actions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Mouse hover failed: " + e.getMessage());
        }
    }

    // Drag and drop
    public void dragAndDrop(String sourceXpath, String targetXpath) {
        try {
            Actions actions = new Actions(driver);
            WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sourceXpath)));
            WebElement target = driver.findElement(By.xpath(targetXpath));
            actions.dragAndDrop(source, target).perform();
        } catch (Exception e) {
            System.out.println("Drag and drop failed: " + e.getMessage());
        }
    }

    // Frame handling
    public void switchToFrame(String type, String value) {
        try {
            switch (type.toLowerCase()) {
                case "index":
                    driver.switchTo().frame(Integer.parseInt(value));
                    break;
                case "name":
                    driver.switchTo().frame(value);
                    break;
                case "xpath":
                    WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
                    driver.switchTo().frame(frame);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid frame switch type: " + type);
            }
        } catch (Exception e) {
            System.out.println("Frame switch failed: " + e.getMessage());
        }
    }

    // Switch back to main page
    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    // Window handling
    public void switchToNewWindow() {
        try {
            String parent = driver.getWindowHandle();
            Set<String> allWindows = driver.getWindowHandles();
            for (String handle : allWindows) {
                if (!handle.equals(parent)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Window switching failed: " + e.getMessage());
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

    // JS Click javascript
    public void jsClick(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.out.println("JS click failed: " + e.getMessage());
        }
    }

    // Scroll to element
    public void scrollToElement(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.out.println("Scroll failed: " + e.getMessage());
        }
    }

    // Explicit wait utility
    public void waitForVisibility(String xpath, int seconds) {
        try {
            WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            customWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            System.out.println("Wait for visibility failed: " + e.getMessage());
        }
    }

    // Get text
    public String getText(String xpath) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText();
        } catch (Exception e) {
            System.out.println("Getting text failed: " + e.getMessage());
            return null;
        }
    }

    // Close browser
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
    // Get current page title
    public String getTitle() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            System.out.println("Failed to get title: " + e.getMessage());
            return null;
        }
    }

}
