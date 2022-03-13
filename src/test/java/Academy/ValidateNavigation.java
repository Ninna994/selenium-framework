package Academy;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

import java.io.IOException;

public class ValidateNavigation extends base {
    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }
    @Test
    public void basePageNavigation() throws IOException {

        LandingPage landing = new LandingPage(driver);
        landing.getModalCloseButton().click();
        Assert.assertTrue(landing.getNavbar().isDisplayed());
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }
}
