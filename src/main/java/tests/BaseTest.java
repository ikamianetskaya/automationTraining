package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException {

        String browserName = getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("edge")) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\msedge.exe");
            driver = new EdgeDriver();
        }


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;

    }
    public String getProperty(String propertyName) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src\\main\\resources\\config.properties");
        prop.load(fis);
       return prop.getProperty(propertyName);
    }

}
