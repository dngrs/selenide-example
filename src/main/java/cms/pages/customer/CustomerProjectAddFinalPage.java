package cms.pages.customer;

import com.codeborne.selenide.SelenideElement;
import cms.pages.AuthorizedUserPage;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class CustomerProjectAddFinalPage extends AuthorizedUserPage {

    public SelenideElement finishButton = $(By.xpath("//span[@class='btn ajax-btn btn-success']")),
            language = $(By.xpath(String.format(summaryItem, "1"))),
            addSubject = $(By.xpath(String.format(summaryItem, "2"))),
            contentType = $(By.xpath(String.format(summaryItem, "3")));

    private static String summaryItem = "(//span[@class='num'])[%s]";

    public CustomerProjectContentTypesPage pressFinishButton() {
        finishButton.shouldBe(visible).click();
        return new CustomerProjectContentTypesPage();
    }

}
