package org.libertex.task.tests;//import io.github.bonigarcia.wdm.WebDriverManager;

import com.codeborne.selenide.Condition;
import org.libertex.task.pages.SearchPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;


public class SearchEngineTest extends BaseTests {
    private SearchPage searchPage;

    @BeforeMethod
    public void navigateToSearchPage() {
        searchPage = searchStartPage.search(SEARCH_VALUE);
    }

    @Test(priority = 1)
    public void verifySearchAriaLabel() {
        searchPage.getHeader()
                .hoverToSearchButton().verifySearchTooltip();
    }

    @Test(priority = 1)
    public void verifySearchInputContainsText() {
        searchPage.getHeader().getInput().shouldHave(text(SEARCH_VALUE));
    }

    @Test(priority = 1)
    public void verifySearchResults() {
        searchPage.getResults().verifyResultsHeaders(SEARCH_VALUE);
    }

    @Test(priority = 1)
    public void verifyGoogleLogoIsPresent() {
        searchPage.getHeader().getLogo().shouldBe(Condition.visible);
    }

    @Test(priority = 2)
    public void verifyGoogleLogoLeadsOnSearchStartPage() {
        searchPage.getHeader().clickLogo().verifyThatPageIsOpened();
    }

}
