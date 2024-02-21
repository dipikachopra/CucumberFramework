package org.openCart.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.opencart.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginPageStepDef {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am the opencart login page")
    public void i_am_the_opencart_login_page() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        loginPage = new LoginPage(driver);
    }

    @Given("I have entered valid username and password")
    public void i_have_entered_valid_username_and_password() {
        loginPage.enterEmail("qatestertest@gmail.com");
        loginPage.enterPassword("Test@123");
    }

    @When("I click on login page")
    public void i_click_on_login_page() {
        loginPage.clickLoginButton();
    }

    @Then("I should be login successfully")
    public void i_should_be_login_successfully() {
      Assert.assertEquals(loginPage.checkLogoutLink(),true);
    }


    @Given("I have Entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @When("I click on login button")
    public void i_click_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I could se error message indicating {string}")
    public void i_could_se_error_message_indicating(String errorMessage) {
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);

    }

    @Given("click on the \"Forgotten password\" link")
    public void clickOnTheLink() {
        loginPage.clickForgotPassword();
    }

    @Then("I Should be redirected to the password reset page")
    public void iShouldBeRedirectedToThePasswordResetPage() {
     Assert.assertTrue(loginPage.getForgetPasswordPageUrl().contains("account/forgotton"));
    }
}


