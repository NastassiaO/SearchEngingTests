package org.libertex.task.modules;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.text;

public class SearchResultsModule {
    @FindBys(@FindBy( how = How.CSS, using = ".DKV0Md"))
    private ElementsCollection resultHeaders;

    public SearchResultsModule verifyResultsHeaders(String expText){;
       resultHeaders.iterator().forEachRemaining(el->
        {
             el.shouldHave(text(expText));
        });
        return this;
    }

}
