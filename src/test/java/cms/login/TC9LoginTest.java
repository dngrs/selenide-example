package cms.login;


import cms.core.TestData;
import cms.pages.AuthorHomePage;
import cms.pages.LoginPage;
import cms.pages.customer.CustomerHomePage;
import cms.core.DriverBase;
import cms.pages.EditorHomePage;
import org.testng.annotations.Test;

public class TC9LoginTest extends DriverBase {

    @Test
    public void loginAsAuthorS1() {

        LoginPage loginPage = new LoginPage();
        AuthorHomePage authorHomePage = new AuthorHomePage();

        loginPage.openPage()
                .checkLoginPageStructure()
                .enterEmailAddress(TestData.Author.AUTHOR_EMAIL)
                .enterPassword(TestData.Author.AUTHOR_PASSWORD)
                .pressSignInButton();
        authorHomePage.checkAuthorIsSignedIn()
                .logOut();

    }

    @Test
    public void loginAsEditorS2() {

        LoginPage loginPage = new LoginPage();
        EditorHomePage editorHomePage = new EditorHomePage();

        loginPage.openPage()
                .enterEmailAddress(TestData.Editor.EDITOR_EMAIL)
                .enterPassword(TestData.Editor.EDITOR_PASSWORD)
                .pressSignInButton();
        editorHomePage.checkEditorIsSignedIn()
                .logOut();

    }

    @Test
    public void loginAsCustomerS3() {

        LoginPage loginPage = new LoginPage();
        CustomerHomePage customerHomePage = new CustomerHomePage();

        loginPage.openPage()
                .enterEmailAddress(TestData.Customer.CUSTOMER_EMAIL)
                .enterPassword(TestData.Customer.CUSTOMER_PASSWORD)
                .pressSignInButton();
        customerHomePage.checkCustomerIsSignedIn()
                .logOut();

    }

}
