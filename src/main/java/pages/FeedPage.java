package pages;

import com.codeborne.selenide.Condition;
import locators_constants.FeedConstants;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage implements FeedConstants {

        public FeedPage waitForFeedPageOpened(){
            $(UPDATE_MOOD_BUTTON_CSS).shouldBe(Condition.visible, Duration.ofSeconds(10));
            return this;
        }

        public RateYourHappinessModal clickOnUpdateMoodButton(){
            $(UPDATE_MOOD_BUTTON_CSS).click();
            return new RateYourHappinessModal();
        }

        public String getMoodLevel(){
            return $(byXpath(GET_MOOD_LEVEL_RESULT)).getText();
        }

    public FeedPage clickToHug(){
        $(byXpath(HUGS_BUTTON)).click();
        return this;
    }

    public FeedPage waitForHug(){
        $(byXpath(HUGS_QUANTITY)).shouldHave(Condition.exactText("1"));
        return this;
    }

    public String getHugQuantity(){
        return $(byXpath(HUGS_QUANTITY)).getText();
    }

}
