package com.automation.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class StepDefinition {
    @Given("user open website")
    public void user_open_website() {

    }

    @Then("verify user os on login page")
    public void verify_user_os_on_login_page() {

    }

    @When("user login valid username and password")
    public void user_login_valid_username_and_password() {

    }

    @Then("verify user is on home page")
    public void verify_user_is_on_home_page() {

    }

    @When("user click on add to cart button of the first item")
    public void user_click_on_add_to_cart_button_of_the_first_item() {

    }

    @Then("verify cart icon displays quantity one")
    public void verify_cart_icon_displays_quantity_one() {

    }

    @When("user click on hamburger menu")
    public void user_click_on_hamburger_menu() {

    }

    @When("click on logout link")
    public void click_on_logout_link() {

    }

    @Then("verify add to cart button for first item is not displayed")
    public void verify_add_to_cart_button_for_first_item_is_not_displayed() {

    }
    @Then("verify user is on login page")
    public void verify_user_is_on_login_page() {

    }

    @Then("verify user is on homepage")
    public void verify_user_is_on_homepage() {

    }

    @When("user login with invalid credentials")
    public void user_login_with_invalid_credentials() {

    }

    @Then("verify invalid login error message is displayed")
    public void verify_invalid_login_error_message_is_displayed() {

    }
    @Given("user opens the website")
    public void user_opens_the_website() {

    }

    @Then("verify user is on the login page")
    public void verify_user_is_on_the_login_page() {

    }

    @When("user logs in with valid username and password")
    public void user_logs_in_with_valid_username_and_password() {

    }

    @Then("verify user is on the home page")
    public void verify_user_is_on_the_home_page() {

    }

    @When("user clicks on the add to cart button of the first item")
    public void user_clicks_on_the_add_to_cart_button_of_the_first_item() {

    }

    @Then("verify the cart icon displays a quantity of one")
    public void verify_the_cart_icon_displays_a_quantity_of_one() {

    }

    @When("user clicks on the cart icon")
    public void user_clicks_on_the_cart_icon() {

    }

    @Then("verify user is on the cart page")
    public void verify_user_is_on_the_cart_page() {

    }

    @When("user clicks on the checkout button")
    public void user_clicks_on_the_checkout_button() {

    }

    @Then("verify user is on the checkout page")
    public void verify_user_is_on_the_checkout_page() {

    }

    @When("user fills all checkout details")
    public void user_fills_all_checkout_details() {

    }

    @When("clicks on the Continue button")
    public void clicks_on_the_continue_button() {

    }

    @Then("verify user is on the review page")
    public void verify_user_is_on_the_review_page() {

    }

    @When("user clicks on the Finish button")
    public void user_clicks_on_the_finish_button() {

    }

    @Then("verify user is on the order confirmation page")
    public void verify_user_is_on_the_order_confirmation_page() {

    }


    @When("user login valid with username {string} and password {string}")
    public void userLoginValidWithUsernameAndPassword(String username, String password) {
        System.out.println(username);
        System.out.println(password);
    }

    @Then("verify list of below username displays on login page")
    public void verifyListOfBelowUsernameDisplaysOnLoginPage(List<List<String>> listOfUsers) {
       for(List<String> rows : listOfUsers){
          for(String data : rows){
              System.out.print(data+" ");
          }
           System.out.println();
       }
    }
}
