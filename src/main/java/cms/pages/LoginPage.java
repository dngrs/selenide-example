package cms.pages;

import cms.core.TestData;
import cms.pages.uielements.Language;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertTrue;

@Getter
public class LoginPage {

    private SelenideElement getStartedButton = $(By.xpath("//div[@class='text-right get-started']/a")),
            loginFormHeader = $(By.xpath("//form/h2")),
            emailField = $(By.xpath("//input[@type='text']")),
            passwordField = $(By.xpath("//input[@type='password']")),
            signInButton = $(By.xpath("//button[@type='submit']")),
            forgotPasswordLink = $(By.xpath("//a[@class='block forgot']")),
            formErrorMessage = $(By.xpath("//div[@class='form-message error']"));

    private String languageSelector = "//span[@data-lang='%s']";

    public LoginPage openPage() {
        Selenide.open(TestData.General.CG_URL);
        if (System.getProperty("lg") == null) {
            changeLanguage(Language.RU);
        }
        return this;
    }

    public LoginPage enterEmailAddress(String email) {
        emailField.should(visible).val(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.should(visible).val(password);
        return this;
    }

    public void pressSignInButton() {
        signInButton.should(visible, enabled).click();
    }

    public void loginWithCredentials(String username, String password) {
        enterEmailAddress(username)
                .enterPassword(password)
                .pressSignInButton();
    }

    public LoginPage changeLanguage(Language language) {
        $(By.xpath(String.format(languageSelector, language.name().toLowerCase()))).click();
        return this;
    }

    public LoginPage checkLoginPageStructure() {
        assertTrue(url().equals(TestData.Login.LOGIN_PAGE_URL));
        loginFormHeader.should(text(TestData.Login.LOGIN_FORM_HEADER_TEXT));
        getStartedButton.should(text(TestData.Login.LOGIN_GET_STARTED_BUTTON_TEXT));
        signInButton.should(text(TestData.Login.LOGIN_SIGNIN_BUTTON_TEXT));
        forgotPasswordLink.should(text(TestData.Login.LOGIN_FORGOT_PASSWORD_TEXT));
        return this;
    }

    public RegistrationPage pressGetStartedButton() {
        getStartedButton.shouldBe(visible).click();
        return new RegistrationPage();
    }

    public LoginPage checkErrorMessageIsDisplayed() {
        formErrorMessage.should(text(TestData.Login.LOGIN_FORM_ERROR_MESSAGE));
        return this;
    }

}
