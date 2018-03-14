package cms.registration;

import cms.pages.LoginPage;
import cms.pages.PrivacyPolicyPage;
import cms.pages.RegistrationPage;
import cms.pages.uielements.Language;
import cms.core.DriverBase;
import org.testng.annotations.Test;

public class TC14PrivacyPolicyTest extends DriverBase {

    @Test
    public void checkTermsOfService() {

        LoginPage loginPage = new LoginPage();
        RegistrationPage registrationPage = new RegistrationPage();
        PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage();

        loginPage.openPage()
                .changeLanguage(Language.RU)
                .pressGetStartedButton();
        registrationPage.clickOnTermsOfServiceLink();
        privacyPolicyPage.checkUserIsOnPrivacyPolicyPage();

    }

}
