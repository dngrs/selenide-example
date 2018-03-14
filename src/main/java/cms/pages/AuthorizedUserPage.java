package cms.pages;

import cms.core.TestData;
import cms.pages.uielements.Profile;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.AssertJUnit.assertTrue;

@Getter
public abstract class AuthorizedUserPage {

    private SelenideElement logo = $(By.xpath("//a[contains(@class, 'logo')]")),
            bellSymbol = $(By.xpath(".//*[@class='bell']")),
            userLogin = $(By.xpath("//div[@class='user pull-right']"));

    private Profile profile = new Profile();

    public Profile profile() {
        return this.profile;
    }

    public LoginPage logOut() {
        profile().logOut();
        return new LoginPage();
    }

    public void checkUserIsLoggedIn(String homePageUrl, String username) {
        logo.shouldBe(visible);
        userLogin.should(text(username));
        bellSymbol.shouldBe(visible);
        assertTrue(url().equals(homePageUrl));
    }

    public void checkUserPopup(String username, String email) {
        profile().getAvatar().should(visible);
        profile().getUsername().should(text(username));
        profile().getUserEmail().should(text(email));
        profile().getShowProfileButton().should(text(TestData.UserProfilePopup.VIEW_PROFILE_BUTTON_TEXT));
        profile().getSettingsLink().should(text(TestData.UserProfilePopup.SETTINGS_LINK_TEXT));
        profile().getLogOutLink().should(text(TestData.UserProfilePopup.LOGOUT_LINK_TEXT));
    }

}
