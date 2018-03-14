package cms.author;

import cms.core.DriverBase;
import cms.core.TestData;
import cms.pages.AuthorHomePage;
import cms.pages.LoginPage;
import cms.pages.MyProfilePage;
import org.testng.annotations.Test;

public class TC1ViewAuthorProfileTest extends DriverBase {

    @Test
    public void viewAuthorProfile() {

        LoginPage loginPage = new LoginPage();
        AuthorHomePage authorHomePage = new AuthorHomePage();
        MyProfilePage myProfilePage = new MyProfilePage();

        loginPage.openPage()
                .loginWithCredentials(TestData.Author.AUTHOR_USER_NAME, TestData.Author.AUTHOR_PASSWORD);
        authorHomePage.profile().clickOn();
        authorHomePage.checkUserPopup(TestData.Author.AUTHOR_USER_NAME, TestData.Author.AUTHOR_EMAIL);
        authorHomePage.profile().pressViewProfileButton();
        myProfilePage.checkAuthorMyProfilePage()
                .logOut();

    }

}
