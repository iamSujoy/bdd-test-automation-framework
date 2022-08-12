package com.swaglabs.pages;

import com.swaglabs.exceptions.EmptyCartException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    private boolean isCartEmpty() throws EmptyCartException {
        if (! driver.getPageSource().contains("Remove"))
            throw new EmptyCartException("Your Cart is Empty...");
        return false;
    }
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CheckoutPage navigateToCheckoutPage() {
        checkoutButton.click();
        return new CheckoutPage(driver);
    }

}
