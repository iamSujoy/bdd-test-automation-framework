Feature: As a user, I want to test the login feature of SwagLabs with different credentials

  @sanity
  Scenario Outline: login tests with different credentials
    Given user navigates to login page "https://www.saucedemo.com/"
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks login button
    Then user should be redirected to products page
    Examples:
      | username        | password     |
      | standard_user   | secret_sauce |
      | problem_user    | secret_sauce |