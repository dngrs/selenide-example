package cms.pages;

import cms.core.TestData;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class TempMailPage {

    private SelenideElement tempEmail = $(By.id("mail")),
            receivedMail = $(By.xpath(".//*[@class='title-subject']")),
            clickHereToRegisterLink = $(By.xpath("//div[@class='pm-text']//a")),
            emailTitle = $(By.xpath("//h4[@class='pm-subject']"));

    public TempMailPage viewEmailDetails() {
        receivedMail.click();
        return this;
    }

    public TempMailPage checkMailStructure() {
        emailTitle.should(text(TestData.TempMail.TEMP_MAIL_MESSAGE_TITLE));
        clickHereToRegisterLink.should(text(TestData.TempMail.TEMP_MAIL_MESSAGE_LINK_TEXT));
        return this;
    }

    public RegistrationPage clickOnRegisterLink() {
        clickHereToRegisterLink.shouldBe(visible).click();
        return new RegistrationPage();
    }

}