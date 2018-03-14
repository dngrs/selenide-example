package cms.pages.customer;

import cms.core.TestData;
import cms.pages.AuthorizedUserPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

@Getter
public class CustomerProjectContentTypesPage extends AuthorizedUserPage {

    private SelenideElement projectName = $(By.xpath(String.format(subMenu, "1"))),
            contentTypes = $(By.xpath(String.format(subMenu, "2")));
    private static String subMenu = "(//div[@id='submenu']//a)[%s]";

    public CustomerProjectContentTypesPage checkPage(){
        projectName.should(Condition.text(TestData.Customer.CUSTOMER_PROJECT_TEST_NAME));
        assertTrue(contentTypes.attr("class").contains("active"));
        return this;
    }

}
