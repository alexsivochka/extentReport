
package tests;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SearchResultsPage;
import utils.listeners.Retry;

import java.lang.reflect.Method;

import static com.codeborne.selenide.Selenide.open;

public class TestSearchPass extends BaseTest{

	SearchPage searchPage = new SearchPage();
	SearchResultsPage searchResultsPage = new SearchResultsPage();



	@Test(testName = "Успешный поиск на странице Google", description = "Поиск на странице Google доджен пройти успешно",
			retryAnalyzer = Retry.class
	)
	public void testShouldPass() {

		open("https://www.google.com.ua/?hl=uk");

		test.log(Status.INFO, "Search for Selenide");
		searchPage.searchOnGoogle("selenide");

		test.log(Status.INFO, "CheckResults");
		searchResultsPage.checkResultsContains("Selenide: лаконичные и стабильные UI тесты на Java");
	}

}
