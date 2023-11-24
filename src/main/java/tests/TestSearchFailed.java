
package tests;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SearchResultsPage;
import utils.listeners.Retry;

import static com.codeborne.selenide.Selenide.open;


public class TestSearchFailed extends BaseTest {

    SearchPage searchPage = new SearchPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();


    @Test(testName = "Неуспешный поиск на странице Google",description = "Поиск на странице Google должен закончиться неудачей",
            retryAnalyzer = Retry.class)
    public void testShouldFailed() {

        open("https://www.google.com.ua/?hl=uk");

        test.log(Status.INFO, "Search for Selenide");
        searchPage.searchOnGoogle("selenide");
        test.log(Status.INFO, "CheckResults");
        searchResultsPage.checkResultsContains("bla-bla-bla");
    }
}
