package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //    objects
    By emailInput = By.id("user_email");
    By password = By.id("user_password");
    By loginButton = By.cssSelector("[type='submit']");

    //    methods
    public WebElement getEmail(){
        return driver.findElement(emailInput);
    }
    public WebElement getPassword(){
        return driver.findElement(password);
    }
    public WebElement getLoginButton(){
        return driver.findElement(loginButton);
    }
}
