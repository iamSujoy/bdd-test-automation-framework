package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmCheckoutPage {
    private WebDriver driver;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public ConfirmCheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ThankYouPage confirmOrder() {
        finishButton.click();
        return new ThankYouPage(driver);
    }
}
