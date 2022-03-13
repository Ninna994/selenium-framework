package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

public class base {
    public WebDriver driver;
    public Properties prop;
    // initialize driver everytime
    public WebDriver initializeDriver() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Ina\\Desktop\\E2EProject\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            //execute in Chrome driver
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            // execute in Firefox
            System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Drivers\\geckodriver.exe");
             driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("egde")) {
            // execute in Edge.
            System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Drivers\\msedgedriver.exe");
             driver = new EdgeDriver();

        }
        // manage Timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return driver;

    }

}
