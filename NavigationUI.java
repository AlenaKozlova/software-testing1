package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject {

    private static final String
    MY_LISTS_LINK = "//aandroid.widget.FrameLayout[@content_desc='My lists']";

    public NavigationUI (AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyList ()
    {
        this.waitForElementAndClick(
                By.xpath(MY_LISTS_LINK),
                "Cannot find button My List",
                5
        );
    }
}
