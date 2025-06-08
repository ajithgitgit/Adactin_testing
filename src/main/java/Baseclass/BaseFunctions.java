package Baseclass;

import io.cucumber.java.eo.Se;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class BaseFunctions {
    private WebDriver driver;

    public WebDriver BrowserLaunch(String browserType){

        WebDriver driver ;
        switch ((browserType.toLowerCase())){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver();
                break;
        }
        switch ((browserType.toLowerCase())){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                this.driver = new FirefoxDriver();
                break;
        }
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return this.driver;
    }

    public void openUrl(String url){
        driver.get(url);
    }

    public void enterTheValue(String xpath, String text) {
       WebElement element = driver.findElement(By.xpath(xpath));
       element.clear();
       element.sendKeys(text);
    }

     public void selectTheValue(String xpath,String by, String option){
        WebElement dropdown = driver.findElement(By.xpath(xpath));
        Select sel = new Select(dropdown);

        switch (by.toLowerCase()){
            case "text":
                sel.selectByVisibleText(option);
                break;

            case "index":
                sel.selectByIndex(Integer.parseInt(option));
                break;
        }



     }
}
