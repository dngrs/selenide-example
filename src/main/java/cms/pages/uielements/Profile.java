package cms.pages.uielements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class Profile {

    private SelenideElement profileIcon = $(".user.pull-right"),
            userPopup = $(".userpopup"),
            avatar = $(".avatar.rounded.table-cell.vat"),
            username = $(".username"),
            userEmail = $(".useremail"),
            showProfileButton = $(By.xpath("(//div[@class='userpopup']//a)[1]")),
            settingsLink = $(By.xpath("(//div[@class='userpopup']//a)[2]")),
            logOutLink = $(By.xpath(".//*[@href='/management/user/signin']"));
    private String languageSelector = "//div[@class='pull-right langswitch']/span[@data-lang='%s']";

    public Profile clickOn() {
        profileIcon.shouldBe(visible).click();
        return this;
    }

    public void setLanguagePreference(Language language) {
        if (!userPopup.isDisplayed()) {
            clickOn();
        }
        $(By.xpath(String.format(languageSelector, language.name().toLowerCase()))).click();
    }

    public void logOut() {
        if (userPopup.isDisplayed()) {
            logOutLink.click();
        } else {
            clickOn();
            logOut();
        }
    }

    public void pressViewProfileButton() {
        showProfileButton.click();
    }

}
