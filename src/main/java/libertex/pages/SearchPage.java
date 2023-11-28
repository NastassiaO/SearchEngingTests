package libertex.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import libertex.modules.SearchHeader;
import libertex.modules.SearchResultsModule;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class SearchPage {
    @FindBy(how = How.CSS, using = "#search")
    private SelenideElement searchResults;

    private SearchHeader searchHeaderModule;
    private SearchResultsModule resultsModule;

    public SearchPage searchPageIsOpened(){
        searchHeaderModule = page(SearchHeader.class);
        searchHeaderModule.isDisplayed();
        return this;
    }

    public SearchHeader getHeader(){
        searchHeaderModule = page(SearchHeader.class);
        return searchHeaderModule;
    }

    public SearchResultsModule getResults(){
        searchResults.shouldBe(Condition.visible);
        resultsModule = page(SearchResultsModule.class);
        return resultsModule;
    }

}
