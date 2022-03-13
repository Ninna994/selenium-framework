package Academy;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePage extends base {
    // for parallel execution
    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String email, String password, String text) throws IOException {

        driver.get(prop.getProperty("url"));
        LandingPage landing = new LandingPage(driver);
        // does not work second time
        if(landing.getModalCloseButton().isDisplayed()){
            landing.getModalCloseButton().click();
        }
        landing.getLogin().click();

        LoginPage login = new LoginPage(driver);
        login.getEmail().sendKeys(email);
        login.getPassword().sendKeys(password);
        System.out.println(text);
        login.getLoginButton().click();

    }

    @DataProvider
    public Object[][] getData(){
        // row stands for how many different data types should run
        // columns - how many values are wqe sending for test - username and password and text
        Object[][] data  = new Object[1][3];
        data[0][0] = "nikolina@gmail.com";
        data[0][1] = "nikolina";
        data[0][2] = "ovo je Ninin text";

      //  data[1][0] = "misa@email.com";
        //data[1][1] = "misa";
        //data[1][2] = "ovo je Misin text";
       return data;
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }
}
