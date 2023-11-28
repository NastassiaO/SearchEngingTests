package libertex.tests;

import org.testng.annotations.Test;


public class SearchStartPageTests extends BaseTests{
    @Test(priority = 1)
    public void verifyPartlySearchDisplayedOnPresentationModule(){
        searchStartPage
                .enterSearchValue(SHORT_SEARCH_VALUE).vewrifyModuleIsDisplayed()
                .verifyPresentationListContainsText(SHORT_SEARCH_VALUE);
        searchStartPage.clearSearchIput().verifyModuleIsNotDisplayed();
    }

    @Test(priority = 2)
    public void verifySearch(){
         searchStartPage
                .enterSearchValue(SEARCH_VALUE)
                 .vewrifyModuleIsDisplayed()
                 .verifyPresentationListContainsText(SEARCH_VALUE)
                 .clickSearchButton().searchPageIsOpened();
    }


}
