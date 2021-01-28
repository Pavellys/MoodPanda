package pages;

import com.codeborne.selenide.Condition;
import constants.RateYourHappinessConstants;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RateYourHappiness implements RateYourHappinessConstants {

    public RateYourHappiness updateMood(int moodValue, String description){
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

    public RateYourHappiness description(String text){
        $(TEXTAREA_CSS).sendKeys(text);
        return this;
    }

    public RateYourHappiness clickToButtonUpdateRate(){
        $(byXpath(RATE_UPDATE_MOOD_BUTTON)).click();
        return this;
    }

    public RateYourHappiness clickMyDiaryButton(){
        $(byXpath(BUTTON_MY_DIARY)).click();
        return this;
    }

    public RateYourHappiness clickToHug(){
        $(byXpath(HUGS_BUTTON)).click();
        return this;
    }

    public RateYourHappiness waitForHug(){
        $(byXpath(HUGS_QUANTITY)).shouldHave(Condition.exactText("1"));
        return this;
    }

    public String getHugQuantity(){
        return $(byXpath(HUGS_QUANTITY)).getText();

    }
}
