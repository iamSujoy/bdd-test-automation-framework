package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    @FindBy(id = "first-name")
    private WebElement firstNameField;
    @FindBy(id = "last-name")
    private WebElement lastNameField;
    @FindBy(id = "postal-code")
    private WebElement postalCodeField;
    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void typeFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }
    private void typeLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }
    private void typePostalCode(String postalCode) {
        postalCodeField.sendKeys(postalCode);
    }

    public CheckoutPage fillBillingInformation(String firstname, String lastname, String postalCode) {
        typeFirstName(firstname);
        typeLastName(lastname);
        typePostalCode(postalCode);
        return this;
    }

    public ConfirmCheckoutPage clickContinueButton() {
        continueButton.click();
        return new ConfirmCheckoutPage(driver);
    }
}
