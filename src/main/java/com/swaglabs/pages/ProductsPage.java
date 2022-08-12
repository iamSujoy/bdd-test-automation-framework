package com.swaglabs.pages;

import com.swaglabs.exceptions.InvalidProductsPageException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {
    private WebDriver driver;

    @FindBy(className = "product_sort_container")
    private WebElement productSortingElement;
    @FindBy(xpath = "//div[@class='inventory_item'][1]//button") //todo
    private WebElement addToCartButton;
    @FindBy(className = "shopping_cart_link")
    private WebElement cartButton;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyProductsPage() throws InvalidProductsPageException {
        if (driver.getPageSource().contains("Products"))
            return true;
        throw new InvalidProductsPageException("You are Not in Products Page");
    }

    public ProductsPage sortProductBasedOnPriceHighToLow() {
        Select select = new Select(productSortingElement);
        select.selectByValue("hilo");
        return this;
    }

    public ProductsPage addToCartFirstProduct() {
        addToCartButton.click();
        return this;
    }

    public CartPage navigateToCartPage() {
        cartButton.click();
        return new CartPage(driver);
    }
}
