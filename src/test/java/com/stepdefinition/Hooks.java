package com.stepdefinition;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import com.Baseclass.BaseClass;
import Utils.ConfigReader;

public class Hooks {

    @Before
    public void setUp() {
        String browser = ConfigReader.get("browser");
        String url = ConfigReader.get("url");

        System.out.println("Launching browser: " + browser);
        BaseClass.launchBrowser(browser);

        System.out.println("Navigating to URL: " + url);
        BaseClass.openUrl(url);

        System.out.println("Browser launched and navigated to " + url);
    }

    @After
    public void tearDown() {
        System.out.println("Closing browser...");
        BaseClass.closeBrowser();
        System.out.println("Browser closed");
    }
}
