Feature: As a user, I want to test the workflow of buying products from
  SwagLabs including checkout process.

  Background: At first, I have to login at SwagLabs site with valid credentials
    Given I navigate to login page "https://www.saucedemo.com/"
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    And I click login button
    Then I should be redirected to products page

  @regression
  Scenario Outline: add products to cart and checkout
    Given I should be in products page
    When I sort the products based on price high to low
    And I add to cart the first product from the list
    And I navigate to cart page
    And I navigate to check out page
    And I fill the billing information "<first_name>" "<last_name>" "<postal_code>" on checkout page
    And I click continue button on checkout page
    And I confirm everything by clicking finish button on confirm checkout page
    Then My order should be placed successfully
    Examples:
      | first_name | last_name | postal_code |
      | John       | Doe       | 123456      |

