package libertex.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;


public class SearchStartPageTests extends BaseTests{


    /**
     * User open the google start page
     * Then enter name to the input
     * Then he sees the preview list results with searched name
     * And list size is 10
     * Then he clears the input
     * And preview list disapear
     */
    @Test(priority = 1)
    public void verifyPartlySearchDisplayedOnPresentationModule(){
        searchStartPage
                .enterSearchValue(SHORT_SEARCH_VALUE).vewrifyModuleIsDisplayed()
                .verifyPresentationListContainsText(SHORT_SEARCH_VALUE)
                .getPresentationList().shouldHave(size(10));
        searchStartPage.clearSearchIput().verifyModuleIsNotDisplayed();
    }

    /**
     * User open the google start page
     * Then enter name and surname to the input
     * Then he sees the preview list results with searched name and surname
     * Then he click on the Search button
     * And sees that Search page opened
     */
    @Test(priority = 2)
    public void verifySearch(){
         searchStartPage
                .enterSearchValue(SEARCH_VALUE)
                 .vewrifyModuleIsDisplayed()
                 .verifyPresentationListContainsText(SEARCH_VALUE)
                 .clickSearchButton().searchPageIsOpened();
    }


}
