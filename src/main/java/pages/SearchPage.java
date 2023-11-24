package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    SelenideElement searchInput = $("textarea[name='q']");

    public void searchOnGoogle(String searchValue){
        searchInput.should(visible, enabled).setValue(searchValue).pressEnter();
    }
}
