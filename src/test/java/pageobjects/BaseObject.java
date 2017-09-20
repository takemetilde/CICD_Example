package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by HHER on 9/4/2017.
 */
public class BaseObject {

    //~ Instance Fields ------------------------------------------------------------------------------------------------

    /**
     * Create Selenium WebDriver instance
     */
    private WebDriver driver;

    private Logger logger = LoggerFactory.getLogger(BaseObject.class);

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Full Constructor
     * @param driver
     */
    public BaseObject(WebDriver driver) {
        this.driver = driver;
    }


    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     * Navigate to the url
     * @param url
     */
    public void get(String url) {
        logger.info("Navigating to " + url);
        driver.get(url);
    }

    /**
     * Locate element
     * @param locator
     * @return WebElement to access locator functions
     */
    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Pass in locator to click
     * @param locator
     */
    public void click(By locator) {
        logger.info("Clicking on " + locator.toString());
        find(locator).click();
    }

    /**
     * Pass in locator and types input
     * @param locator
     * @param input
     */
    public void type(By locator, String input) {
        logger.info("Typing " + input + " into " + locator.toString());
        find(locator).sendKeys(input);
    }

    /**
     * Selects the input by visible text in dropdown locator
     * @param locator
     * @param input
     */
    public void select(By locator, String input) {
        logger.info("Selecting " + input + " from " + locator.toString() + " drop-down");
        Select select = new Select(find(locator));
        select.selectByVisibleText(input);
    }

    /**
     * Check if locator is displayed and throws no such element exception
     * @param locator
     * @return
     */
    public Boolean isDisplayed(By locator) {
        try{
            logger.info("Checking if " + locator.toString() + " is displayed");
            return find(locator).isDisplayed();
        } catch (NoSuchElementException exp) {
            logger.info(locator.toString() + " is not displayed: " + exp);
            return false;
        }
    }
}
