package cms.customer;

import cms.core.TestData;
import cms.pages.customer.CustomerHomePage;
import cms.pages.customer.CustomerProjectAddSubjectPage;
import cms.pages.uielements.Subject;
import cms.core.DriverBase;
import cms.pages.LoginPage;
import cms.pages.customer.CustomerProjectAddPage;
import org.testng.annotations.Test;

public class TC8SearchBySubjectTest extends DriverBase {

    @Test
    public void searchBySubject() {

        LoginPage loginPage = new LoginPage();
        CustomerHomePage customerHomePage = new CustomerHomePage();
        CustomerProjectAddPage customerProjectAddPage = new CustomerProjectAddPage();
        CustomerProjectAddSubjectPage customerProjectAddSubjectPage = new CustomerProjectAddSubjectPage();

        loginPage.openPage()
                .loginWithCredentials(TestData.Customer.CUSTOMER_USER_NAME, TestData.Customer.CUSTOMER_PASSWORD);
        customerHomePage.goToProjectPage()
                .pressAddProjectButton();
        customerProjectAddPage.enterProjectName(TestData.Customer.CUSTOMER_PROJECT_TEST_NAME)
                .selectLanguage(customerProjectAddPage.getRuLanguage())
                .pressNextButton();
        customerProjectAddSubjectPage.clickOnExpandSubjectListButton(Subject.БИЗНЕС)
                .enterInSearchField(TestData.Customer.CUSTOMER_PROJECT_SUBJECT_SEARCH_TEXT)
                .checkSubItemsList(TestData.Customer.CUSTOMER_PROJECT_SUBJECT_SEARCH_TEXT);
        customerProjectAddSubjectPage.logOut();

    }

}
