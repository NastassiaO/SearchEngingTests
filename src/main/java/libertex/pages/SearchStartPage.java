package libertex.pages;

import com.codeborne.selenide.*;
import libertex.modules.PresentationModule;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

public class SearchStartPage {
    @FindBy(how = How.XPATH, using = "//textarea[@name='q']")
    private SelenideElement formSearch;

    @FindBy(how = How.CSS, using = ".lnXdpd")
    private SelenideElement logo;

public boolean isPopUpOpened(){
    return $(".dbsFrd").isDisplayed();
}
    public SearchStartPage verifyThatPageIsOpened(){
        logo.should(Condition.visible);
        return this;
    }
    public SelenideElement getInput(){
        return formSearch;
    }
    public PresentationModule enterSearchValue(String searchStr){
        formSearch.click();
        formSearch.append(searchStr);
        return page(PresentationModule.class);
    }

    public PresentationModule clearSearchIput(){
        formSearch.clear();
        return page(PresentationModule.class);
    }

    public SearchPage search(String searchStr){
        formSearch.click();
        formSearch.append(searchStr).pressEnter();
        return Selenide.page(SearchPage.class);
    }



}
