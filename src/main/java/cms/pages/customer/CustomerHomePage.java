package cms.pages.customer;

import com.codeborne.selenide.SelenideElement;
import cms.pages.AuthorizedUserPage;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static cms.core.TestData.Customer.CUSTOMER_HOME_PAGE_URL;
import static cms.core.TestData.Customer.CUSTOMER_PAGE_TITLE;
import static cms.core.TestData.Customer.CUSTOMER_PEOPLE_TEXT;
import static cms.core.TestData.Customer.CUSTOMER_PROJECTS_TEXT;
import static cms.core.TestData.Customer.CUSTOMER_USER_NAME;

@Getter
public class CustomerHomePage extends AuthorizedUserPage {

    private SelenideElement projects = $(By.xpath(".//*[@href='/management/projects']")),
            people = $(By.xpath(".//*[@href='/management/people']")),
            pageHeader = $(".page-header");

    public CustomerHomePage checkCustomerIsSignedIn() {
        checkUserIsLoggedIn(CUSTOMER_HOME_PAGE_URL, CUSTOMER_USER_NAME);
        checkCustomerMenu();
        return this;
    }

    public CustomerHomePage checkCustomerIsSignedIn(String username) {
        checkUserIsLoggedIn(CUSTOMER_HOME_PAGE_URL, username);
        checkCustomerMenu();
        return this;
    }

    private void checkCustomerMenu() {
        projects.should(exist, text(CUSTOMER_PROJECTS_TEXT));
        people.should(exist, text(CUSTOMER_PEOPLE_TEXT));
    }

    public CustomerHomePage checkInterfaceLanguage() {
        pageHeader.should(text(CUSTOMER_PAGE_TITLE));
        projects.should(text(CUSTOMER_PROJECTS_TEXT));
        people.should(text(CUSTOMER_PEOPLE_TEXT));
        return this;
    }

    public CustomerPeoplePage goToPeoplePage() {
        people.shouldBe(visible).click();
        return new CustomerPeoplePage();
    }

    public CustomerProjectPage goToProjectPage(){
        projects.shouldBe(visible).click();
        return new CustomerProjectPage();
    }

}
