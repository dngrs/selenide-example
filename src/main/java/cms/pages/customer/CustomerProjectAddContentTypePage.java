package cms.pages.customer;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cms.pages.AuthorizedUserPage;
import cms.pages.uielements.ContentType;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class CustomerProjectAddContentTypePage extends AuthorizedUserPage {

    private SelenideElement nextButton = $(By.xpath("//a[@class='next btn btn-danger']"));
    private ElementsCollection contentTypeItems = $$(By.xpath("//div[@class='type-item']/div"));

    public CustomerProjectAddContentTypePage selectContentType(ContentType contentType) {
        contentTypeItems.findBy(text(contentType.name().toLowerCase())).click();
        return this;
    }

    public CustomerProjectAddFinalPage pressNextButton() {
        nextButton.shouldBe(visible).click();
        return new CustomerProjectAddFinalPage();
    }

}
