package libertex.modules;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import libertex.pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class PresentationModule {
    @FindBys(@FindBy( how = How.CSS, using = ".OBMEnb .sbct"))
    private ElementsCollection presentationList;

    @FindBy(how = How.CSS, using = ".UUbT9.EyBRub")
    private SelenideElement presentationModule;

    @FindBy(how = How.CSS, using = ".UUbT9.EyBRub .gNO89b")
    private SelenideElement searchButton;


    public PresentationModule vewrifyModuleIsDisplayed(){
       presentationModule.shouldBe(visible);
        return this;
    }

    public PresentationModule verifyModuleIsNotDisplayed(){
        presentationModule.shouldBe(visible);
        return this;
    }

    public ElementsCollection getPresentationList(){
        return presentationList;
    }

    public PresentationModule verifyPresentationListContainsText(String expText){;
        presentationList.iterator().forEachRemaining(el->
        {
            el.find(By.cssSelector("span")).shouldHave(text(expText));
        });
        return this;
    }

    public SearchPage clickSearchButton(){
        searchButton.scrollIntoView(true).click();
        return page(SearchPage.class);
    }

}
