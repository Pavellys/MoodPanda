package pages;

import com.codeborne.selenide.Condition;
import locators_constants.LoginConstants;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LoginPage implements LoginConstants {

    public FeedPage login(String email, String password){
        $(EMAIL_INPUT_CSS).sendKeys(email);
        $(PASSWORD_INPUT_CSS).sendKeys(password);
        $(BUTTON_LOGIN_CSS).click();
        return new FeedPage();
    }

    public LoginPage openPage(){
        open(LOGIN_URL);
        return this;
    }

    public LoginPage waitForLoginFormOpened(){
        $(GOOGLE_PLAY_ICON_CSS).shouldBe(Condition.visible, Duration.ofSeconds(20));
        return this;
    }

    public String getCurrentURL(){
        return url();
    }
}
