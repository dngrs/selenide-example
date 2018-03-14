package cms.pages.customer;

import cms.pages.AuthorizedUserPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class CustomerPeoplePage extends AuthorizedUserPage {

    private SelenideElement inviteToProjectButton = $(By.xpath("//div[@class='projects project-team']/span")),
            inviteToProjectPopup = $(By.xpath("//div[@class='project-team-content']")),
            emailField = $(By.xpath("//input[@class='email']")),
            inviteButton = $(By.xpath("//form[@class='emailinvite']/div[2]/span[2]"));
    private ElementsCollection listOfInviteEmails = $$(By.xpath("//div[@class='user-line-item full']/strong"));

    public CustomerPeoplePage pressInviteToProjectButton() {
        inviteToProjectButton.shouldBe(visible).click();
        return this;
    }

    public CustomerPeoplePage enterEmail(String email) {
        emailField.shouldBe(visible).val(email);
        return this;
    }

    public CustomerPeoplePage pressInviteButton() {
        inviteButton.shouldBe(visible).click();
        return this;
    }

    public CustomerPeoplePage checkInvitationExists(String email) {
        //TODO: not finished
        return this;
    }

}
