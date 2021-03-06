package resources;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class base {
    public WebDriver driver;
    public Properties prop;
    // initialize driver everytime
    public WebDriver initializeDriver() throws IOException {

        prop = new Properties();

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            // chrome headless
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("headless");
            //execute in Chrome driver
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\main\\java\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            // execute in Firefox
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\src\\main\\java\\resources\\drivers\\geckodriver.exe");
             driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("egde")) {
            // execute in Edge.
            System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") + "\\src\\main\\java\\resources\\drivers\\msedgedriver.exe");
             driver = new EdgeDriver();
        } else if(browserName.equalsIgnoreCase("chrome-headless")){
            // chrome headless
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            //execute in Chrome driver
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\main\\java\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver(options);
        }
        // manage Timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return driver;

    }

    public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }

}
