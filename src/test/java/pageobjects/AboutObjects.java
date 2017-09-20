package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by HHER on 9/4/2017.
 */
public class AboutObjects extends BaseObject{

    //~ Instance Fields ------------------------------------------------------------------------------------------------

    By sponsorLinkLocator = By.linkText("Sponsors");


    //~ Constructors ---------------------------------------------------------------------------------------------------

    public AboutObjects(WebDriver driver) {
        super(driver);
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public void navigateToSponsorsLinkFromAboutTab() {
        navigateToSponsorsLinkFromAboutTab();
        click(sponsorLinkLocator);
    }

}
