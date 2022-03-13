package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassPage {
    public WebDriver driver;

    public ForgotPassPage(WebDriver driver){
        this.driver =driver;
    }

    By email = By.id("user_email");
    By send = By.name("commit");
    public WebElement getEmail() {
        return driver.findElement(email);
    }
    public WebElement getSend() {
        return driver.findElement(send);
    }



}
