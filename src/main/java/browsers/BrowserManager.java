package browsers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManager {
    public static  WebDriver driver;
    
    
    
	
    public static void Browser_Launch() {
        // Create a Properties object to load the property file
        Properties properties = new Properties();
        
        try {
            // Load the config.properties file
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Get the browser value from the properties file
        String browser = properties.getProperty("browser", "chrome").toLowerCase();  // Default to "chrome" if not set
        String loginName =properties.getProperty("login_name","test").toLowerCase(); //Default to localhost if not set
        System.out.println("Login name: " + loginName);
        String url = urlBasedLogin(loginName);
        
        // Launch the browser based on the value in the properties file
        switch (browser) {
            case "chrome":
            	WebDriverManager.chromedriver().setup();
            	
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "safari":
                // Safari driver is built-in on macOS, no need to use WebDriverManager
                driver = new SafariDriver();
                break;

            default:
                System.out.println("Invalid browser selection.");
                return;
        }

        // Maximize the browser window
        driver.manage().window().maximize();

        // Open a website test url
        driver.get(url);
       
    }
        // Method to return the appropriate URL based on login name
        private static String urlBasedLogin(String loginName) {
            switch (loginName) {
                case "live":
                    return "https://knruhs.uonex.in/";
                case "test":
                    return "http://103.154.253.118:81/";
                case "localhost":
                    return "http://localhost:8080/";
                default:
                    System.out.println("Invalid login name, defaulting to localhost.");
                    return "http://localhost:8080/";
            }
        }
        //live url
     //   driver.get("https://knruhs.uonex.in/");

        // Close the browser (optional)
        // driver.quit();
    }