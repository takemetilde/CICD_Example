package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.HomeObjects;

/**
 * Created by HHER on 9/4/2017.
 */
public class HomeTests extends BaseTest {

    //~ Instance Fields ------------------------------------------------------------------------------------------------

    private HomeObjects homeObjects;

    //~ Setup and Initialization ---------------------------------------------------------------------------------------

    /**
     * Set up before by instantiating home objects
     */
    @BeforeTest
    public void setUp() {
        homeObjects = new HomeObjects(driver);
    }

    //~ Tests ----------------------------------------------------------------------------------------------------------

    @Test
    public void TC_0010_ClickAboutTabSuccessful() {
        homeObjects.navigateToAboutTab();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = homeObjects.getBaseUrl() + "/about/";
        Assert.assertTrue(actualUrl.equals(expectedUrl), "\nExpected Url: " + expectedUrl
                + "\nActual Url: " + actualUrl);
    }
}
