package libertex.tests;

import libertex.modules.CookiePopUp;
import libertex.pages.SearchStartPage;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class BaseTests {
    protected static String SEARCH_VALUE = "Michael Jackson";
    protected static String SHORT_SEARCH_VALUE = "Michael";
    protected SearchStartPage searchStartPage;
    @BeforeMethod
    public void openSearchPage(){
        open("https://www.google.com/webhp");
        searchStartPage = page(SearchStartPage.class);
        if (searchStartPage.isPopUpOpened()) {
            searchStartPage = page(CookiePopUp.class).close().verifyThatPageIsOpened();
        }
    }


}
