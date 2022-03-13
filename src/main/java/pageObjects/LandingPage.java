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
   private By login = By.cssSelector("a[href*='sign_in']");
   private By modalCloseButton = By.className("sumome-react-wysiwyg-close-button");
   private By featuredCoursesText = By.cssSelector(".text-center>h2");
   private By navbar = By.className("navbar-nav");
   private By title = By.cssSelector(".video-banner h3");


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
    public WebElement getTitle() {
        return driver.findElement(title);
    }
}
