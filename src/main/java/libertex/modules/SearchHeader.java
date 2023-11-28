package libertex.modules;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import libertex.pages.SearchStartPage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import static com.codeborne.selenide.Selenide.*;

public class SearchHeader {
    @FindBy(how = How.CSS, using = ".CvDJxb")
    private SelenideElement searchHeader;

    public SearchHeader isDisplayed(){
        searchHeader.shouldBe(Condition.visible);
        return this;
    }

    public SelenideElement getLogo(){
        return searchHeader.$("#logo");
    }

    public SearchStartPage clickLogo(){
        getLogo().click();
        return page(SearchStartPage.class);
    }

    public SelenideElement getInput(){
        return searchHeader.$x(".//textarea[@class= 'gLFyf']");
    }

    public SelenideElement getSearchButton(){
        return  searchHeader.$(".Tg7LZd");
    }

    public SearchHeader hoverToSearchButton(){
       actions().moveToElement(getSearchButton()).build().perform();
       return this;
    }

    public SearchHeader verifySearchTooltip(){
        getSearchButton().shouldHave(Condition.attribute("aria-label", "Search"));
        return this;
    }

}
