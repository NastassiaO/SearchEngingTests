package libertex.modules;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import libertex.pages.SearchStartPage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class CookiePopUp {
    @FindBy(how = How.CSS, using = ".lnXdpd")
    private SelenideElement cookiePopUp;

    @FindBy(how = How.CSS, using = "#L2AGLb")
    private SelenideElement acceptAllBtn;

    public Boolean isDisplayed(){
        return cookiePopUp!=null;
    }

    public SearchStartPage close(){
        cookiePopUp.should(Condition.visible);
        acceptAllBtn.scrollIntoView(true).click();
        return page( SearchStartPage.class);
    }

}
