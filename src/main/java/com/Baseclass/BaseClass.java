package com.Baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait wait;

    // Launch browser with implicit wait and explicit wait initialization
    public static WebDriver launchBrowser(String browserType) {
        try {
            switch (browserType.toLowerCase()) {
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new");   // Headless Chrome (Chrome 109+)
                    options.addArguments("--disable-gpu");
                    options.addArguments("--window-size=1920,1080");
                    driver = new ChromeDriver(options);
                    break;
                }
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("-headless");         // Headless Firefox
                    driver = new FirefoxDriver(options);
                    break;
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments("--headless=new");   // Headless Edge (Edge 114+)
                    options.addArguments("--disable-gpu");
                    options.addArguments("--window-size=1920,1080");
                    driver = new EdgeDriver(options);
                    break;
                }
                default:
                    throw new IllegalArgumentException("Invalid browser type: " + browserType);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // explicit wait
        } catch (Exception e) {
            System.err.println("Browser launch failed: " + e.getMessage());
            throw e;
        }
        return driver;
    }

    // Open URL
    public static void openUrl(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            System.err.println("Failed to open URL: " + e.getMessage());
            throw e;
        }
    }

    // Enter text into element identified by xpath
    public void enterText(String xpath, String text) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(text);
        } catch (TimeoutException e) {
            System.err.println("Timeout waiting for element to enter text: " + xpath);
            throw e;
        } catch (Exception e) {
            System.err.println("Error entering text into element (" + xpath + "): " + e.getMessage());
        }
    }

    // Click element identified by xpath
    public void clickElement(String xpath) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            element.click();
        } catch (TimeoutException e) {
            System.err.println("Timeout waiting for clickable element: " + xpath);
            throw e;
        } catch (Exception e) {
            System.err.println("Error clicking element (" + xpath + "): " + e.getMessage());
        }
    }

    // Select dropdown by visible text, value or index
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
                    throw new IllegalArgumentException("Invalid dropdown select type: " + type);
            }
        } catch (Exception e) {
            System.err.println("Dropdown selection failed (" + xpath + "): " + e.getMessage());
            throw e;
        }
    }

    // Mouse hover over element
    public void mouseHover(String xpath) {
        try {
            Actions actions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.err.println("Mouse hover failed (" + xpath + "): " + e.getMessage());
        }
    }

    // Drag and drop source element to target element
    public void dragAndDrop(String sourceXpath, String targetXpath) {
        try {
            Actions actions = new Actions(driver);
            WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sourceXpath)));
            WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(targetXpath)));
            actions.dragAndDrop(source, target).perform();
        } catch (Exception e) {
            System.err.println("Drag and drop failed (" + sourceXpath + " to " + targetXpath + "): " + e.getMessage());
        }
    }

    // Switch to frame by index, name, or xpath
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
            System.err.println("Frame switch failed (" + type + ": " + value + "): " + e.getMessage());
        }
    }

    // Switch back to main document
    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    // Switch to new window different from parent
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
            System.err.println("Window switching failed: " + e.getMessage());
        }
    }

    // Take screenshot and save to specified folder
    public void takeScreenshot(String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            String dest = "src/test/screenshots/" + fileName + ".png";
            FileUtils.copyFile(src, new File(dest));
            System.out.println("Screenshot saved: " + dest);
        } catch (IOException e) {
            System.err.println("Screenshot failed: " + e.getMessage());
        }
    }

    // Javascript click on element
    public void jsClick(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.err.println("JS click failed (" + xpath + "): " + e.getMessage());
        }
    }

    // Scroll element into view
    public void scrollToElement(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.err.println("Scroll failed (" + xpath + "): " + e.getMessage());
        }
    }

    // Explicit wait for visibility of element
    public void waitForVisibility(String xpath, int seconds) {
        try {
            WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            customWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            System.err.println("Wait for visibility failed (" + xpath + "): " + e.getMessage());
        }
    }

    // Get text from element
    public String getText(String xpath) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText();
        } catch (Exception e) {
            System.err.println("Getting text failed (" + xpath + "): " + e.getMessage());
            return null;
        }
    }

    // Close browser session
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed");
        }
    }

    // Get current page title
    public String getTitle() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            System.err.println("Failed to get title: " + e.getMessage());
            return null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
