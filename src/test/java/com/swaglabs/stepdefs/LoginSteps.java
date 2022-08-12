package com.swaglabs.stepdefs;

import com.swaglabs.base.TestBase;
import com.swaglabs.exceptions.InvalidProductsPageException;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.pages.ProductsPage;
import com.swaglabs.utils.LogUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.swaglabs.base.TestBase.driver;

public class LoginSteps {
    LoginPage loginPage;
    ProductsPage productsPage;

    @Given("user navigates to login page {string}")
    public void user_navigates_to_login_page(String url) {
        LogUtility.logInfo("user loads login page");
        driver.get(url);
        loginPage = new LoginPage(driver);
    }
    @When("user enters username {string}")
    public void user_enters_username(String username) {
        LogUtility.logInfo("user types username..");
        loginPage.typeUserName(username);
    }
    @When("user enters password {string}")
    public void user_enters_password(String password) {
        LogUtility.logInfo("user types password..");
        loginPage.typePassword(password);
    }
    @When("user clicks login button")
    public void user_clicks_login_button() {
        LogUtility.logInfo("user clicks on login button");
        productsPage = loginPage.login();
    }
    @Then("user should be redirected to products page")
    public void user_should_be_redirected_to_products_page() {
        try {
            Assert.assertTrue(productsPage.verifyProductsPage());
        } catch (InvalidProductsPageException e) {
            LogUtility.logError("user not in products page. error occurred ");
            Assert.fail();
        }
    }

}
