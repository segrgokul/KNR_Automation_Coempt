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

import base.BasicFunctions;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjMod.pom;

public class BrowserManager {


        public static WebDriver driver;
        public static Properties properties = new Properties();

        public static void Browser_Launch() {
            // Load the configuration file
            try {
                FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
                properties.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            // Get browser and environment details from properties file
            String browser = properties.getProperty("browser", "chrome").toLowerCase();
            String loginName = properties.getProperty("login_name", "test").toLowerCase();
            String username = properties.getProperty(loginName + "_username", "defaultUser");
            String password = properties.getProperty(loginName + "_password", "defaultPass");
            String url = urlBasedLogin(loginName);

            // Launch browser
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
                    driver = new SafariDriver();
                    break;
                default:
                    System.out.println("Invalid browser selection.");
                    return;
            }

            // Maximize and open URL
            driver.manage().window().maximize();
            driver.get(url);

            // Perform login
            Login(username, password);
        }

        // Method to return the appropriate URL based on login name
        private static String urlBasedLogin(String loginName) {
            switch (loginName) {
                case "live":
                    return "https://knruhs.uonex.in/";
                case "test":
                    return "http://103.154.253.118:81/";
                case "localhost":
                    return "http://localhost:5084/";
                default:
                    System.out.println("Invalid login name, defaulting to localhost.");
                    return "https://sctevt-qa.uonex.in/sn20Yz";
            }
        }

        // Login Method
        public static void Login(String username, String password) {
            try {
            	BasicFunctions.implicitWait(30);
            	BasicFunctions.explicitWait(pom.getInstanceLoginXP().userName, 30);
            	BasicFunctions.click(pom.getInstanceLoginXP().userName);
            	BasicFunctions.implicitWait(30);
            	BasicFunctions.sendKeys(pom.getInstanceLoginXP().userName, username);
            	BasicFunctions.implicitWait(30);
            	BasicFunctions.explicitWait(pom.getInstanceLoginXP().userpass, 30);
            	BasicFunctions.click(pom.getInstanceLoginXP().userpass);
            	BasicFunctions.implicitWait(30);
            	BasicFunctions.sendKeys(pom.getInstanceLoginXP().userpass, password);
            	BasicFunctions.implicitWait(30);
            	BasicFunctions.explicitWait(pom.getInstanceLoginXP().signinBtn, 30);
            	BasicFunctions.click(pom.getInstanceLoginXP().signinBtn);
            	BasicFunctions.implicitWait(30);
            	BasicFunctions.explicitWait(pom.getInstanceLoginXP().loginTags, 30);
                if (pom.getInstanceLoginXP().loginTags.isDisplayed()) {
                    System.out.println("The Admin Login Page has logged in, and the landing page of KNRUHS is displayed.");
                }
            } catch (Exception e) {
                System.out.println("Login failed: " + e.getMessage());
            }
        }
    }
