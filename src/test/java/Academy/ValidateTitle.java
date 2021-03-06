package Academy;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

import java.io.IOException;

public class ValidateTitle extends base {
    // for parallel execution
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(base.class.getName());
    LandingPage landing;
    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("Navigated to Homepage");
    }

    @Test
    public void basePageNavigation() throws IOException {
        landing = new LandingPage(driver);
        landing.getModalCloseButton().click();
        Assert.assertEquals(landing.getFeaturedCoursesText().getText(), "FEATURED COURSES");
        log.info("Successfully validated Featured Courses");
    }

    @Test
    public void validatePageH1(){
   Assert.assertEquals(landing.getTitle().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }

}
