package lib.ui;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListPageObject extends MainPageObject {
    public static final String
            FOLDER_BY_NAME_TPL = "//*[@text='{FOLDER_NAME}']",
            ARTICLE_BY_TITLE_TPL = "//*[@text='{TITLE}']";

    private static String getFolderXPathByName (String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle (String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public MyListPageObject (AppiumDriver driver)
    {
        super(driver);
    }

    public void openFolderByName (String name_of_folder)
    {
        String folder_name_xpath = getFolderXPathByName(name_of_folder);
        this.waitForElementAndClick(
                By.xpath(folder_name_xpath),
                "Cannot find created folder (Cannot find folder by name)" + name_of_folder,
                5
        );
    }
    public void waitForArticleToApearByTitle (String article_title)
    {
        String article_xpath = getFolderXPathByName(article_title);
        this.waitForElementPresent(By.xpath(article_xpath), "SCAnnot find saved article by title" + article_title, 15);

    }



    public void waitForArticleToDissapearByTitle (String article_title)
    {
        String article_xpath = getFolderXPathByName(article_title);
        this.waitForElementNotPresent(By.xpath(article_xpath), "Saved article still rpesent with title" + article_title, 15);

    }

    public void swipeByArticleToDelite (String article_title)
    {
        this.waitForArticleToApearByTitle(article_title);

        String article_xpath = getFolderXPathByName(article_title);
        this.swipeElementToLeft(
                By.xpath(article_xpath),
                "Cannot find create articler'"
        );
        this.waitForArticleToDissapearByTitle(article_title);
    }
}
