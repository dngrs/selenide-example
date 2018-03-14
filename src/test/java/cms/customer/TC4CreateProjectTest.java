package cms.customer;

import cms.pages.customer.CustomerProjectAddContentTypePage;
import cms.pages.customer.CustomerProjectAddSubjectPage;
import cms.pages.uielements.ContentType;
import cms.core.DriverBase;
import cms.pages.customer.CustomerHomePage;
import cms.pages.LoginPage;
import cms.pages.customer.CustomerProjectAddFinalPage;
import cms.pages.customer.CustomerProjectAddPage;
import cms.pages.customer.CustomerProjectContentTypesPage;
import org.testng.annotations.Test;

import static cms.core.TestData.Customer.CUSTOMER_PASSWORD;
import static cms.core.TestData.Customer.CUSTOMER_PROJECT_TEST_NAME;
import static cms.core.TestData.Customer.CUSTOMER_USER_NAME;
import static cms.pages.uielements.Subject.АВТОМОБИЛИ;

public class TC4CreateProjectTest extends DriverBase {

    @Test
    public void createProject() {

        LoginPage loginPage = new LoginPage();
        CustomerHomePage customerHomePage = new CustomerHomePage();
        CustomerProjectAddPage customerProjectAddPage = new CustomerProjectAddPage();
        CustomerProjectAddSubjectPage customerProjectAddSubjectPage = new CustomerProjectAddSubjectPage();
        CustomerProjectAddContentTypePage customerProjectAddContentTypePage = new CustomerProjectAddContentTypePage();
        CustomerProjectAddFinalPage customerProjectAddFinalPage = new CustomerProjectAddFinalPage();
        CustomerProjectContentTypesPage customerProjectContentTypesPage = new CustomerProjectContentTypesPage();

        loginPage.openPage()
                .loginWithCredentials(CUSTOMER_USER_NAME, CUSTOMER_PASSWORD);
        customerHomePage.goToProjectPage()
                .pressAddProjectButton();
        customerProjectAddPage.enterProjectName(CUSTOMER_PROJECT_TEST_NAME)
                .selectLanguage(customerProjectAddPage.getRuLanguage())
                .pressNextButton();
        customerProjectAddSubjectPage.selectSubject(АВТОМОБИЛИ)
                .pressNextButton();
        customerProjectAddContentTypePage.selectContentType(ContentType.НОВОСТЬ)
                .pressNextButton();
        customerProjectAddFinalPage.pressFinishButton();
        customerProjectContentTypesPage.checkPage();

        customerHomePage.goToProjectPage()
                .deleteProject(CUSTOMER_PROJECT_TEST_NAME)
                .logOut();

    }

}
