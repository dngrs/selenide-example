package cms.pages;

import cms.core.TestData;
import cms.pages.uielements.Role;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.AssertJUnit.assertTrue;

@Getter
public class RegistrationPage {

    private SelenideElement inviteKeyField = $(By.xpath("(//input)[1]")),
            usernameField = $(By.xpath("(//input)[2]")),
            emailField = $(By.xpath("(//input)[3]")),
            passwordField = $(By.xpath("(//input[@type='password'])[1]")),
            repeatPasswordField = $(By.xpath("(//input[@type='password'])[2]")),
            roleSelector = $(By.xpath("//input[@class='select-list']")),
            signUpButton = $(By.xpath("//form//button")),
            termsOfServiceLink = $(By.xpath("//div[@class='terms']/a"));
    private static String rolePattern = "//li[@data-id='ROLE_%s']";

    public RegistrationPage fillRegistrationForm(
            String inviteKey,
            String username,
            String email,
            String password,
            String repeatPassword,
            Role role
    ) {
        inviteKeyField.shouldBe(visible).val(inviteKey);
        usernameField.shouldBe(visible).val(username);
        emailField.shouldBe(visible).val(email);
        passwordField.shouldBe(visible).val(password);
        repeatPasswordField.shouldBe(visible).val(repeatPassword);
        selectRole(role);
        return this;
    }

    public RegistrationPage selectRole(Role role) {
        roleSelector.click();
        $(By.xpath(String.format(rolePattern, role.name()))).shouldBe(visible).click();
        return this;
    }

    public void pressSignUpButton() {
        signUpButton.shouldBe(visible).click();
    }

    public void checkUserIsOnRegistrationPage() {
        assertTrue(url().equals(TestData.Registration.REGISTRATION_EMAIL_CG_LINK));
    }

    public RegistrationPage checkSignUpButtonIsDisabled() {
        assertTrue(signUpButton.attr("class").contains("disabled"));
        return this;
    }

    public void clickOnTermsOfServiceLink() {
        termsOfServiceLink.shouldBe(visible).click();
    }

}
