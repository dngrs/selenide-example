package cms.registration;

import cms.core.TestData;
import cms.pages.LoginPage;
import cms.pages.RegistrationPage;
import cms.pages.uielements.Role;
import cms.core.DriverBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC12CheckRegistrationButtonTest extends DriverBase {

    @Test(dataProvider = "registrationWithInputs")
    public void checkSignUpButtonIsDisabled(String inviteKey,
                                            String username,
                                            String email,
                                            String password,
                                            String repeatPassword,
                                            Role role) {

        LoginPage loginPage = new LoginPage();
        RegistrationPage registrationPage = new RegistrationPage();

        loginPage.openPage()
                .pressGetStartedButton();
        registrationPage.fillRegistrationForm(
                inviteKey,
                username,
                email,
                password,
                repeatPassword,
                role);
        registrationPage.checkSignUpButtonIsDisabled();
    }

    @DataProvider
    public static Object[][] registrationWithInputs() {
        return new Object[][]{
                {TestData.Registration.REGISTRATION_INVALID_INVITE_KEY,
                        TestData.Registration.REGISTRATION_VALID_USERNAME,
                        TestData.Registration.REGISTRATION_VALID_EMAIL,
                        TestData.Registration.REGISTRATION_DEFAULT_PASSWORD,
                        TestData.Registration.REGISTRATION_DEFAULT_PASSWORD,
                        Role.AUTHOR
                },
                {TestData.Registration.REGISTRATION_INVITE_KEY,
                        TestData.Registration.REGISTRATION_INVALID_USERNAME,
                        TestData.Registration.REGISTRATION_VALID_EMAIL,
                        TestData.Registration.REGISTRATION_DEFAULT_PASSWORD,
                        TestData.Registration.REGISTRATION_DEFAULT_PASSWORD,
                        Role.AUTHOR
                },
                {TestData.Registration.REGISTRATION_INVITE_KEY,
                        TestData.Registration.REGISTRATION_VALID_USERNAME,
                        TestData.Registration.REGISTRATION_INVALID_EMAIL,
                        TestData.Registration.REGISTRATION_DEFAULT_PASSWORD,
                        TestData.Registration.REGISTRATION_DEFAULT_PASSWORD,
                        Role.AUTHOR
                },
                {TestData.Registration.REGISTRATION_INVITE_KEY,
                        TestData.Registration.REGISTRATION_VALID_USERNAME,
                        TestData.Registration.REGISTRATION_VALID_EMAIL,
                        TestData.Registration.REGISTRATION_INVALID_PASSWORD,
                        TestData.Registration.REGISTRATION_INVALID_PASSWORD,
                        Role.AUTHOR
                },
                {TestData.Registration.REGISTRATION_INVITE_KEY,
                        TestData.Registration.REGISTRATION_VALID_USERNAME,
                        TestData.Registration.REGISTRATION_VALID_EMAIL,
                        TestData.Registration.REGISTRATION_DEFAULT_PASSWORD,
                        TestData.Registration.REGISTRATION_INVALID_PASSWORD,
                        Role.AUTHOR
                }
        };
    }
}
