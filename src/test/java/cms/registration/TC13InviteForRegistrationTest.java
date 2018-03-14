package cms.registration;

import cms.core.DriverBase;
import cms.core.TestData;
import cms.pages.LoginPage;
import cms.pages.RegistrationPage;
import cms.pages.TempMailPage;
import cms.pages.customer.CustomerHomePage;
import cms.pages.uielements.Language;
import cms.util.Helper;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.switchTo;

public class TC13InviteForRegistrationTest extends DriverBase {

    @Test
    public void checkInvitationTest() {

        TempMailPage tempMailPage = new TempMailPage();
        LoginPage loginPage = new LoginPage();
        CustomerHomePage customerHomePage = new CustomerHomePage();
        RegistrationPage registrationPage = new RegistrationPage();

        Selenide.open(TestData.TempMail.TEMP_MAIL_URL);
        String email = tempMailPage.getTempEmail().val();
        Helper.openInNewTab(TestData.General.CG_URL);
        switchTo().window(TestData.Login.LOGIN_PAGE_TITLE);
        loginPage.changeLanguage(Language.RU)
                .loginWithCredentials(TestData.Customer.CUSTOMER_USER_NAME, TestData.Customer.CUSTOMER_PASSWORD);
        customerHomePage.goToPeoplePage()
                .pressInviteToProjectButton()
                .enterEmail(email)
                .pressInviteButton()
                .logOut();
        switchTo().window(TestData.TempMail.TEMP_MAIL_TITLE);
        tempMailPage.getReceivedMail()
                .waitUntil(exist, TestData.TempMail.TEMP_MAIL_WAIT);
        tempMailPage.viewEmailDetails()
                .checkMailStructure()
                .clickOnRegisterLink();
        switchTo().window(2);
        registrationPage.checkUserIsOnRegistrationPage();

    }

}
