package com.swaglabs.stepdefs;

import com.swaglabs.exceptions.InvalidProductsPageException;
import com.swaglabs.pages.*;
import com.swaglabs.utils.LogUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.swaglabs.base.TestBase.driver;

public class UserFlowSteps {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    ConfirmCheckoutPage confirmCheckoutPage;
    ThankYouPage thankYouPage;

    @Given("I navigate to login page {string}")
    public void i_navigate_to_login_page(String url) {
        LogUtility.logInfo("user loads login page");
        driver.get(url);
        loginPage = new LoginPage(driver);
    }
    @When("I enter username {string}")
    public void i_enter_username(String username) {
        LogUtility.logInfo("user types username..");
        loginPage.typeUserName(username);
    }
    @When("I enter password {string}")
    public void i_enter_password(String password) {
        LogUtility.logInfo("user types password..");
        loginPage.typePassword(password);
    }
    @When("I click login button")
    public void i_click_login_button() {
        LogUtility.logInfo("user clicks on login button");
        productsPage = loginPage.login();
    }
    @Then("I should be redirected to products page")
    public void i_should_be_redirected_to_products_page() {
        try {
            Assert.assertTrue(productsPage.verifyProductsPage());
        } catch (InvalidProductsPageException e) {
            LogUtility.logError("user not in products page. error occurred ");
            Assert.fail();
        }
    }
    @Given("I should be in products page")
    public void i_should_be_in_products_page() {
        LogUtility.logInfo("user in products page..");
    }
    @When("I sort the products based on price high to low")
    public void i_sort_the_products_based_on_price_high_to_low() {
        LogUtility.logInfo("user sorts the products based on price high to low..");
        productsPage.sortProductBasedOnPriceHighToLow();
    }
    @When("I add to cart the first product from the list")
    public void i_add_to_cart_the_first_product_from_the_list() {
        LogUtility.logInfo("user adds first item to cart..");
        productsPage.addToCartFirstProduct();
    }
    @When("I navigate to cart page")
    public void i_navigate_to_cart_page() {
        LogUtility.logInfo("user navigates to cart page..");
        cartPage = productsPage.navigateToCartPage();
    }
    @When("I navigate to check out page")
    public void i_navigate_to_check_out_page() {
        LogUtility.logInfo("user navigates to checkout page..");
        checkoutPage = cartPage.navigateToCheckoutPage();
    }
    @When("I fill the billing information {string} {string} {string} on checkout page")
    public void i_fill_the_billing_information_on_checkout_page(String firstName, String lastName, String postalCode) {
        LogUtility.logInfo("user fills billing information on checkout page..");
        checkoutPage.fillBillingInformation(firstName, lastName, postalCode);
    }
    @When("I click continue button on checkout page")
    public void i_click_continue_button_on_checkout_page() {
        LogUtility.logInfo("user clicks continue button on checkout page..");
        confirmCheckoutPage = checkoutPage.clickContinueButton();
    }
    @When("I confirm everything by clicking finish button on confirm checkout page")
    public void i_confirm_everything_by_clicking_finish_button_on_confirm_checkout_page() {
        LogUtility.logInfo("user in confirm checkout page..");
        thankYouPage = confirmCheckoutPage.confirmOrder();
    }
    @Then("My order should be placed successfully")
    public void my_order_should_be_placed_successfully() {
        LogUtility.logInfo("user placed the order successfully..");
        Assert.assertTrue(thankYouPage.isOrderPlaced());
    }
}