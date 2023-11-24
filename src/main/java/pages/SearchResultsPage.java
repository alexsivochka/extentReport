package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {

    ElementsCollection results = $$("a h3");

    public void checkResultsContains(String expectedResult){
        results.shouldHave(sizeGreaterThanOrEqual(1)).filterBy(visible)
                .shouldHave(itemWithText(expectedResult));
    }

}
