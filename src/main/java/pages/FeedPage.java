package pages;

import com.codeborne.selenide.Condition;
import constants.FeedConstants;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage implements FeedConstants {

        public pages.FeedPage waitForFeedPageOpened(){
            $(UPDATE_MOOD_BUTTON_CSS).shouldBe(Condition.visible, Duration.ofSeconds(10));
            return this;
        }

        public RateYourHappiness clickOnUpdateMoodButton(){
            $(UPDATE_MOOD_BUTTON_CSS).click();
            return new RateYourHappiness();
        }

        public String getMoodLevel(){
            return $(byXpath(GET_MOOD_LEVEL_RESULT)).getText();
        }

}
