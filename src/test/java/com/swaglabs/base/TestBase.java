package com.swaglabs.base;

import com.swaglabs.utils.LogUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    public static WebDriver driver;

    public void configureLocalBrowser(String browserName, boolean browserHeadless) {
        LogUtility.logInfo("opening browser : "+browserName+", HeadlessMode :"+browserHeadless);
        switch (browserName) {
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (browserHeadless)
                    chromeOptions.addArguments("headless");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (browserHeadless)
                    firefoxOptions.setHeadless(true);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge" :
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if (browserHeadless)
                    edgeOptions.addArguments("headless");
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                driver = new HtmlUnitDriver(true);
        }

        driver.manage().window().maximize();
    }

    public void configureRemoteBrowser(String browserName, boolean browserHeadless, String remoteURL) {
        LogUtility.logInfo("opening remote browser : "+browserName+", HeadlessMode :"+browserHeadless);
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName(browserName);
            // todo: write for headless mode...
            driver = new RemoteWebDriver(new URL(remoteURL), cap);
            driver.manage().window().maximize();
        } catch (MalformedURLException e) {
            LogUtility.logError("Not able to open remote driver...");
        }
    }
}
