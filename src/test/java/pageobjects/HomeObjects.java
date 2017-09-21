package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by HHER on 9/4/2017.
 */
public class HomeObjects extends BaseObject {

    //~ Instance Fields ------------------------------------------------------------------------------------------------

    private By aboutTabLocator = By.linkText("About");
    private By searchBarLocator = By.id("q");
    private String baseUrl = "http://www.seleniumhq.org";


    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Default Constructor
     * @param driver
     */
    public HomeObjects(WebDriver driver) { super(driver); }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * Navigate to the About tab
     */
    public void navigateToAboutTab() {
        get(baseUrl);
        click(aboutTabLocator);
    }

    /**
     * Type 'Testing Platform' in the search bar
     */
    public void searchForTestingPlatform() {
        type(searchBarLocator, "Testing Platforms");
    }

}
