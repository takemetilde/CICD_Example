package tests;

import com.saucelabs.saucerest.SauceREST;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pageobjects.Config;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by HHER on 9/4/2017.
 */
public class BaseTest implements Config {

    //~ Variables/Instances --------------------------------------------------------------------------------------------

    /**
     * Create instance of driver to be initialized
     */
    protected WebDriver driver;
    Logger logger = LoggerFactory.getLogger(BaseTest.class);
    private String testName;
    private String sessionId;
    private SauceREST sauceClient;

    //~ Setup and Initialization ---------------------------------------------------------------------------------------

    /**
     * Overriding before() and instantiating ChromeDriver
     */
    @BeforeSuite
    public void setup() throws MalformedURLException {
        if (host.equals("saucelabs")) {
            sauceLabsSetup();
        }

        else if (browser.equals("firefox")) {
            firefoxSetup();
        }

        // If browser = 'chrome', locate and set chrome driver, create new instance
        else if (browser.equals("chrome")) {
            chromeSetup();
        }
    }


    /**
     * Overriding after() for teardown
     */
    @AfterSuite
    public void teardown() {
        driver.quit();
    }

    public void sauceLabsSetup() throws  MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("version", browserVersion);
        capabilities.setCapability("platform", platform);
        capabilities.setCapability("name", testName);
        String sauceUrl = String.format(
                "http://%s:%s@ondemand.saucelabs.com:80/wd/hub",
                sauceUser, sauceKey);

        /**
         * Create new instance of remote driver for saucelabs, log session, and log in
         */
        driver = new RemoteWebDriver(new URL(sauceUrl), capabilities);
        sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
        sauceClient = new SauceREST(sauceUser, sauceKey);
    }

    public void firefoxSetup() {
        driver = new FirefoxDriver();
    }

    public void chromeSetup() {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/drivers/chromedriver_win32.exe");
        logger.info("Setting WebDriver to: " + System.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
    }
}