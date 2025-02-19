package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class LoginSteps {
    WebDriver driver = DriverFactory.getDriver();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://www.demoblaze.com/");
        driver.findElement(By.id("login2")).click(); // Klik tombol login
    }

    @When("I enter a valid username and password")
    public void i_enter_a_valid_username_and_password() {
        driver.findElement(By.id("loginusername")).sendKeys("validUser");
        driver.findElement(By.id("loginpassword")).sendKeys("validPassword");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("I should be redirected to the home page")
    public void i_should_be_redirected_to_the_home_page() {
        Assert.assertTrue(driver.findElement(By.id("nameofuser")).isDisplayed());
    }

    @Then("I should see a welcome message")
    public void i_should_see_a_welcome_message() {
        Assert.assertTrue(driver.findElement(By.id("nameofuser")).getText().contains("Welcome"));
    }

    @When("I enter an invalid username or password")
    public void i_enter_an_invalid_username_or_password() {
        driver.findElement(By.id("loginusername")).sendKeys("invalidUser");
        driver.findElement(By.id("loginpassword")).sendKeys("wrongPassword");
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String errorMessage) {
        Assert.assertTrue(driver.switchTo().alert().getText().contains(errorMessage));
        driver.switchTo().alert().accept();
    }

    @When("I leave the username and password fields empty")
    public void i_leave_the_username_and_password_fields_empty() {
        driver.findElement(By.id("loginusername")).sendKeys("");
        driver.findElement(By.id("loginpassword")).sendKeys("");
    }
}
