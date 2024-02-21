package org.opencart.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    //By Locators
    private By emailInputLocator =By.xpath("//input[@name='email']");
    private By passwordInputLocator =By.xpath("//input[@name='password']");
    private By loginButtonLocator =By.xpath("//input[@type='submit']");
    private By forgottonPasswordLinkLocator = By.linkText("Forgotten Password");
    private By logoutLinkLocator =By.linkText("logout");

    //Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Methods
    public void enterEmail(String email){
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }
    public void enterPassword(String password){
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
       WebElement loginButton =  driver.findElement(loginButtonLocator);
       loginButton.click();
    }

    public void clickForgotPassword(){
        driver.findElement(forgottonPasswordLinkLocator).click();
    }

    public boolean checkForgotPassword(){
        return driver.findElement(forgottonPasswordLinkLocator).isDisplayed();
    }

    public boolean checkLogoutLink(){
        return driver.findElement(logoutLinkLocator).isDisplayed();
    }

    public void login(String email,String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public String getForgetPasswordPageUrl(){
        String forgotPasswordPageUrl = driver.getCurrentUrl();
        return forgotPasswordPageUrl;
    }




}
