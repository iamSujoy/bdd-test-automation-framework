package com.swaglabs.stepdefs;

import com.swaglabs.base.TestBase;
import com.swaglabs.utils.LogUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static com.swaglabs.base.TestBase.driver;

public class Hooks {
    public TestBase testBase;
    private String browserName;
    private boolean isHeadless;

    public Hooks() { setProperties(); }

    private void setProperties() {
        Properties properties = new Properties();
        try {
            LogUtility.logInfo("loading project config.properties file");
            properties.load(new FileReader("src/main/resources/config.properties"));
            browserName = properties.getProperty("browserName");
            isHeadless = Boolean.parseBoolean(properties.getProperty("headlessMode"));
        } catch (IOException e) {
            LogUtility.logError("error occurred at loading config.properties file");
            throw new RuntimeException(e);
        }
    }

    @Before()
    public void openBrowser() {
        testBase = new TestBase();
        testBase.configureBrowser(browserName, isHeadless);
    }

    @After(order = 1)
    public void takeScreenshotOnFail(Scenario scenario) {
        if (scenario.isFailed()) {
            LogUtility.logInfo("taking screenshot on failed scenario : "+scenario.getName());
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);

        }
    }

    @After(order = 0)
    public void quitBrowser() {
        LogUtility.logInfo("quiting browser...");
        driver.quit();
    }
}
