package cms.registration;

import cms.pages.uielements.Language;
import cms.core.DriverBase;
import cms.pages.AuthorHomePage;
import cms.pages.customer.CustomerHomePage;
import cms.pages.EditorHomePage;
import cms.pages.LoginPage;
import cms.pages.RegistrationPage;
import cms.pages.TempMailPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static cms.core.TestData.General.CG_URL;
import static cms.core.TestData.Login.LOGIN_PAGE_TITLE;
import static cms.core.TestData.Registration.REGISTRATION_DEFAULT_PASSWORD;
import static cms.core.TestData.Registration.REGISTRATION_INVITE_KEY;
import static cms.core.TestData.TempMail.TEMP_MAIL_URL;
import static cms.pages.uielements.Role.AUTHOR;
import static cms.pages.uielements.Role.CUSTOMER;
import static cms.pages.uielements.Role.EDITOR;
import static cms.util.Helper.generateUsernameFromEmail;
import static cms.util.Helper.openInNewTab;

public class TC11RegistrationTest extends DriverBase {

    private TempMailPage tempEmailPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private String eamail;
    private String username;

    @BeforeMethod
    public void setup() {

        tempEmailPage = new TempMailPage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        open(TEMP_MAIL_URL);
        eamail = tempEmailPage.getTempEmail().val();
        openInNewTab(CG_URL);
        switchTo().window(LOGIN_PAGE_TITLE);
        username = generateUsernameFromEmail(eamail);

    }

    @Test
    public void signUpAsAuthorS1() {

        AuthorHomePage authorHomePage = new AuthorHomePage();

        loginPage.changeLanguage(Language.RU)
                .pressGetStartedButton();
        registrationPage.fillRegistrationForm(
                REGISTRATION_INVITE_KEY,
                username,
                eamail,
                REGISTRATION_DEFAULT_PASSWORD,
                REGISTRATION_DEFAULT_PASSWORD,
                AUTHOR
        )
                .pressSignUpButton();
        authorHomePage.checkAuthorIsSignedIn(username)
                .logOut();

    }

    @Test
    public void signUpAsEditorS2() {

        EditorHomePage editorHomePage = new EditorHomePage();

        loginPage.changeLanguage(Language.RU)
                .pressGetStartedButton();
        registrationPage.fillRegistrationForm(
                REGISTRATION_INVITE_KEY,
                username,
                eamail,
                REGISTRATION_DEFAULT_PASSWORD,
                REGISTRATION_DEFAULT_PASSWORD,
                EDITOR
        )
                .pressSignUpButton();
        editorHomePage.checkEditorIsSignedIn(username)
                .logOut();

    }

    @Test
    public void signUpAsCustomerS3() {

        CustomerHomePage customerHomePage = new CustomerHomePage();

        loginPage.changeLanguage(Language.RU)
                .pressGetStartedButton();
        registrationPage.fillRegistrationForm(
                REGISTRATION_INVITE_KEY,
                username,
                eamail,
                REGISTRATION_DEFAULT_PASSWORD,
                REGISTRATION_DEFAULT_PASSWORD,
                CUSTOMER
        )
                .pressSignUpButton();
        customerHomePage.checkCustomerIsSignedIn(username)
                .logOut();

    }

}
