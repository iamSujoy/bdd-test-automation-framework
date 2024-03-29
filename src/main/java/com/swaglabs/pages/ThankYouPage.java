package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPage {
    private WebDriver driver;
    public ThankYouPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isOrderPlaced() {
        if (driver.getPageSource().contains("Thank you for your order!"))
            return true;
        else
            return false;
    }
}
