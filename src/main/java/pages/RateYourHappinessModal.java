package pages;

import locators_constants.RateYourHappinessConstants;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RateYourHappinessModal implements RateYourHappinessConstants {

    public RateYourHappinessModal updateMood(int moodValue, String description){
        $(SLIDER_CSS).click();
        int defaultMood = 5;
        Keys direction;
        if (moodValue > defaultMood){
            direction = Keys.ARROW_RIGHT;
        }else{
            direction = Keys.ARROW_LEFT;
        }
        for(int i = 0; i < Math.abs(moodValue - defaultMood) ; i++){
           $(SLIDER_CSS).sendKeys(direction);
        }
        return this;
    }

    public RateYourHappinessModal description(String text){
        $(TEXTAREA_CSS).sendKeys(text);
        return this;
    }

    public MoodUpdatedModal clickToButtonUpdateRate(){
        $(byXpath(RATE_UPDATE_MOOD_BUTTON)).click();
        return new MoodUpdatedModal();
    }
}
