@Test
    public void firstTest() 
    {
        WebElement element_to_init_search = driver.findElementByXPath("//*[contains(@text,'Search Wikipedia')]");
        element_to_init_search.click();

        WebElement element_to_enter_search_line = driver.findElementByXPath ("//*[contains(@text,'Search…')]";
        element_to_init_search.click();

        assert(element_to_init_search.getText('Search…'));

    }
