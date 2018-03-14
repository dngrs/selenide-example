package cms.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static cms.core.TestData.Author.AUTHOR_EMAIL;
import static cms.core.TestData.Author.AUTHOR_USER_NAME;
import static cms.core.TestData.Customer.CUSTOMER_EMAIL;
import static cms.core.TestData.Customer.CUSTOMER_USER_NAME;
import static cms.core.TestData.MyProfile.CHANGE_PASSWORD_TEXT;
import static cms.core.TestData.MyProfile.MY_PROFILE_TEXT;
import static cms.core.TestData.MyProfile.PROFESSIONAL_SKILLS_TEXT;
import static cms.core.TestData.MyProfile.URL;
import static org.testng.AssertJUnit.assertTrue;

@Getter
public class MyProfilePage extends AuthorizedUserPage {

    private SelenideElement myProfile = $(By.xpath(String.format(userMenu, "1"))),
            changePassword = $(By.xpath(String.format(userMenu, "2"))),
            professionalSkills = $(By.xpath(String.format(userMenu, "3"))),
            updateButton = $(By.xpath("//span[@class='btn btn-info upload']")),
            avatar = $(By.xpath("///div[@class='avatar rounded']")),
            username = $(By.xpath(String.format(profileInfo, "1"))),
            editUsernameLink = $(By.xpath(String.format(editLink, "1"))),
            email = $(By.xpath(String.format(profileInfo, "2"))),
            editEmailLink = $(By.xpath(String.format(editLink, "2"))),
            saveUsernameButton = $(By.xpath("(//div[@class='clearfix profile-field'])[1]//span[1]")),
            saveEmailButton = $(By.xpath("(//div[@class='clearfix profile-field'])[2]//span[1]"));

    private static String userMenu = "//div[@class='usermenu']//li[%s]/a",
            profileInfo = "(//div[@class='profile-field-info'])[%s]",
            editLink = "(//div[@class='profile-field-info'])[%s]/../span",
            editableTextField = "//input[@value='%s']";

    public MyProfilePage checkAuthorMyProfilePage() {
        professionalSkills.should(text(PROFESSIONAL_SKILLS_TEXT));
        checkMyProfilePage(AUTHOR_USER_NAME, AUTHOR_EMAIL);
        return this;
    }

    public MyProfilePage checkCustomerMyProfilePage() {
        checkMyProfilePage(CUSTOMER_USER_NAME, CUSTOMER_EMAIL);
        return this;
    }

    private void checkMyProfilePage(String expectedUsername, String expectedEmail) {
        myProfile.should(text(MY_PROFILE_TEXT));
        changePassword.should(text(CHANGE_PASSWORD_TEXT));
        assertTrue(url().equals(URL));
        username.should(text(expectedUsername));
        editUsernameLink.shouldBe(visible);
        email.should(text(expectedEmail));
        editUsernameLink.shouldBe(visible);
    }

    public MyProfilePage clickOnEditUsernameLink() {
        editUsernameLink.shouldBe(visible).click();
        return this;
    }

    public MyProfilePage enterUsername(String newUsername, String currentUsername) {
        SelenideElement editableUsernameField = $(By.xpath(String.format(editableTextField, currentUsername)));
        editableUsernameField.clear();
        editableUsernameField.val(newUsername);
        return this;
    }

    public MyProfilePage pressSaveUsernameButton() {
        saveUsernameButton.click();
        return this;
    }

    public MyProfilePage checkUserNameIsCorrect(String expectedUsername) {
        getUserLogin().should(text(expectedUsername));
        username.should(text(expectedUsername));
        return this;
    }

    public MyProfilePage changeUsername(String newUsername, String currentUsername) {
        clickOnEditUsernameLink();
        enterUsername(newUsername, currentUsername);
        pressSaveUsernameButton();
        checkUserNameIsCorrect(newUsername);
        return this;
    }

    public MyProfilePage clickOnEditEmailLink() {
        editEmailLink.shouldBe(visible).click();
        return this;
    }

    public MyProfilePage enterEmail(String newEmail, String currentEmail) {
        SelenideElement editableEmailField = $(By.xpath(String.format(editableTextField, currentEmail)));
        editableEmailField.clear();
        editableEmailField.val(newEmail);
        return this;
    }

    public MyProfilePage pressSaveEmailButton() {
        saveEmailButton.click();
        return this;
    }

    public MyProfilePage checkEmailIsCorrect(String expectedEmail) {
        email.should(text(expectedEmail));
        profile().clickOn();
        profile().getUserEmail().should(text(expectedEmail));
        profile().clickOn();
        return this;
    }

    public MyProfilePage changeEmail(String newEmail, String currentEmail) {
        clickOnEditEmailLink();
        enterEmail(newEmail, currentEmail);
        pressSaveEmailButton();
        checkEmailIsCorrect(newEmail);
        return this;
    }

}
