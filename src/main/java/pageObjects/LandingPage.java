package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    //    objects
    By login = By.cssSelector("a[href*='sign_in']");
    By modalCloseButton = By.className("sumome-react-wysiwyg-close-button");
    By featuredCoursesText = By.cssSelector(".text-center>h2");
    By navbar = By.className("navbar-nav");


    //    methods
    public LoginPage getLogin() {
         driver.findElement(login).click();
         LoginPage login = new LoginPage(driver);
         return  login;
    }

    public WebElement getModalCloseButton() {
        return driver.findElement(modalCloseButton);
    }

    public WebElement getFeaturedCoursesText() {
        return driver.findElement(featuredCoursesText);
    }

    public WebElement getNavbar() {
        return driver.findElement(navbar);
    }
}
