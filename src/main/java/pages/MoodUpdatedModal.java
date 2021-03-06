package pages;

import test_data.MoodUpdatedModalConstants;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MoodUpdatedModal implements MoodUpdatedModalConstants {

    public FeedPage clickMyDiaryButton(){
        $(byXpath(BUTTON_MY_DIARY)).click();
        return new FeedPage();
    }
}
