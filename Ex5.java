@Test
    public void saveArticleToMyList()
        {
            waitForElementAndClick(
                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                    "Cannot find Search Wikipedia input",
                    5
            );
            waitForElementAndSendyKeys(
                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                    "Java",
                    "Cannot find search input",
                    5
            );
            waitForElementAndClick(
                    By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                    "Cannot find Search Wikipedia input",
                    5
            );
            waitForElementPresent(
                    By.id("org.wikipedia:id/view_page_title_text"),
                    "Cannot find article title",
                    15
            );
            waitForElementAndClick(
                    By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                    "Cannot find button to open article options",
                    5

            );
            waitForElementAndClick(
                    By.xpath("//*[@text='Add to reading list']"),
                    "Cannot find option to add article to my list",
                    5
            );
            waitForElementAndClick(
                    By.id("org.wikipedia:id/onboarding_button"),
                    "Cannot find 'COT IT' button",
                    5
            );
            waitForElementAndClear(
                    By.id("org.wikipedia:id/text_input"),
                    "Cannot find input to write name of folder",
                    5
            );
            waitForElementAndSendyKeys(
                    By.id("org.wikipedia:id/text_input"),
                    "Learning programming",
                    "Cannot put text into articles folder",
                    5
            );
            waitForElementAndClick(
                    By.xpath("//*[@text='OK']"),
                    "Cannot press OK button",
                    5
            );
            waitForElementAndClick(
                    By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                    "Cannot close article by X button",
                    5
            );
            waitForElementAndClick(
                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                    "Cannot find Search Wikipedia input",
                    5
            );
            waitForElementAndSendyKeys(
                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                    "Appium",
                    "Cannot find search input",
                    5
            );
            waitForElementAndClick(
                    By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']"),
                    "Cannot find 'Appium' in search",
                    5
            );
            waitForElementPresent(
                    By.id("org.wikipedia:id/view_page_title_text"),
                    "Cannot find article title",
                    15
            );
            waitForElementAndClick(
                    By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                    "Cannot find button to open article options",
                    5

            );
            waitForElementAndClick(
                    By.xpath("//*[@text='Add to reading list']"),
                    "Cannot find option to add article to my list",
                    5
            );
            waitForElementAndClick(
                    By.xpath("//*[@text='Learning programming']"),
                    "Cannot find 'Learning programming' to add in My List",
                    5
            );
            waitForElementAndClick(
                    By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                    "Cannot close article by X button",
                    5
            );
            waitForElementAndClick(
                    By.xpath("//aandroid.widget.FrameLayout[@content_desc='My lists']"),
                    "Cannot find button My List",
                    5
            );
            waitForElementAndClick(
                    By.xpath("//*[@text='Learning programming']"),
                    "Cannot press on title of My list 'Learning programming'",
                    5
            );
            waitForElementAndClick(
                    By.xpath("//*[@text='Java (programming language)']"),
                    "Cannot find created folder'",
                    5
            );
            swipeElementToLeft(
                    By.xpath("//*[@text='Java (programming language)']"),
                    "Cannot find create articler'"
            );
            waitForElementNotPresent(
                    By.xpath("//*[@text='Java (programming language)']"),
                    "Saved article stil on the page",
                    5
            );
            waitForElementPresent(
                    By.xpath("//*[@text='Appium']"),
                    "There is no saved article Appium on the page",
                    5
            );


        }
       
        private WebElement waitForElementPresent(By by, String error_massages, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_massages + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementPresentByXPath(By by, String error_massages) {
        return waitForElementPresent(by, error_massages, 5);
    }

    private WebElement waitForElementAndClick(By by, String error_massage, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_massage, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendyKeys(By by, String value, String error_massage, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_massage, timeoutInSeconds);
        element.sendKeys(value);
        return element;

    }

    private boolean waitForElementNotPresent(By by, String error_massage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_massage + "/n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClear(By by, String error_massage, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_massage, timeoutInSeconds);
        element.clear();
        return element;
    }

    protected void swipeElementToLeft(By by, String error_massage)
    {
        WebElement element = waitForElementPresent(
                by,
                error_massage,
                10);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x, middle_y)
                .waitAction(150)
                .moveTo(left_x, middle_y)
                .release()
                .perform();
    }


