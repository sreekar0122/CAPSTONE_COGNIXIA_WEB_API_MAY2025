package tests;

import utility.constant;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SearchPage;

public class SearchTest extends TestBase {

    @Test(priority = 1)
    public void positiveSearchTest() throws InterruptedException {
        driver.get(constant.Demoqa_appurl + constant.BOOKS_PAGE);
        log.info("Navigated to books page.");

        SearchPage searchPage = new SearchPage(driver);

        Thread.sleep(2000); 

        searchPage.enterSearch(constant.POSITIVE_SEARCH_TERM);

        Thread.sleep(2000); 

        boolean resultDisplayed = searchPage.isResultDisplayed(constant.POSITIVE_BOOK_RESULT);

        Assert.assertTrue(resultDisplayed, "Expected search result not found.");

        log.info("Positive book search test passed.");
    }

    @Test(priority = 2)
    public void negativeSearchTest() throws InterruptedException {
        driver.get(constant.Demoqa_appurl + constant.BOOKS_PAGE);
        log.info("Navigated to books page.");

        SearchPage searchPage = new SearchPage(driver);

        Thread.sleep(2000); 

        searchPage.enterSearch(constant.NEGATIVE_SEARCH_TERM);

        Thread.sleep(2000); 

        boolean resultDisplayed = searchPage.isResultDisplayed(constant.NEGATIVE_BOOK_RESULT);

        Assert.assertFalse(resultDisplayed, "Unexpected search result found for invalid input.");

        log.info("Negative book search test passed.");
    }
}
