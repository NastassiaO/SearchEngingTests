package libertex.tests;//import io.github.bonigarcia.wdm.WebDriverManager;

import com.codeborne.selenide.Condition;
import libertex.pages.SearchPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;


public class SearchEngineTest extends BaseTests {
    private SearchPage searchPage;

    @BeforeMethod
    public void navigateToSearchPage() {
        searchPage = searchStartPage.search(SEARCH_VALUE);
    }

    /**
     * User move mouse on search button and see tooltip. But tooltip now is ariasl label
     * and I didn't find a way how to check that tooltip is displayed
     */
    @Test(priority = 1)
    public void verifySearchAriaLabel() {
        searchPage.getHeader()
                .hoverToSearchButton().verifySearchTooltip();
    }

    /**
     * User see the text that he entered for search in the header input
     */
    @Test(priority = 1)
    public void verifySearchInputContainsText() {
        searchPage.getHeader().getInput().shouldHave(text(SEARCH_VALUE));
    }

    /**
     * User see the results contains text as he searched
     */
    @Test(priority = 1)
    public void verifySearchResults() {
        searchPage.getResults().verifyResultsHeaders(SEARCH_VALUE);
    }

    /**
     * User see the google logo in the header
     */
    @Test(priority = 1)
    public void verifyGoogleLogoIsPresent() {
        searchPage.getHeader().getLogo().shouldBe(Condition.visible);
    }

    /**
     * User click to the google logo and navigated to the start search page
     * Then he sees that search input is empty
     */
    @Test(priority = 2)
    public void verifyGoogleLogoLeadsOnSearchStartPage() {
        searchPage.getHeader().clickLogo().verifyThatPageIsOpened()
                .getInput().shouldHave(Condition.text(""));
    }

}
