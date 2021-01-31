package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest{

    @Test(description = "Checking authorization")
    public void loginTest(){
        loginPage
                .openPage()
                .waitForLoginFormOpened()
                .login(USER_EMAIL, USER_PASSWORD)
                .waitForFeedPageOpened();
        Assert.assertEquals(loginPage.getCurrentURL(), EXPECTED_LOGIN_RESULT);
    }

    @Test(description = "Checking create my current mood and click on the button Hug")
    public void rateHappinessTest(){
        loginPage
                .openPage()
                .waitForLoginFormOpened()
                .login(USER_EMAIL, USER_PASSWORD)
                .waitForFeedPageOpened()
                .clickOnUpdateMoodButton()
                .updateMood(7, MOOD_MESSAGE)
                .description(MOOD_MESSAGE)
                .clickToButtonUpdateRate()
                .clickMyDiaryButton()
                .clickToHug()
                .waitForHug();
        Assert.assertEquals(feedPage.getMoodLevel(), EXPECTED_MOOD_LEVEL);
        Assert.assertEquals(feedPage.getHugQuantity(), EXPECTED_HUGS_QUANTITY);
    }
}
