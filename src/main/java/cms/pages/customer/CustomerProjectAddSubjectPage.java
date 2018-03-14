package cms.pages.customer;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cms.pages.AuthorizedUserPage;
import cms.pages.uielements.Subject;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertTrue;

@Getter
public class CustomerProjectAddSubjectPage extends AuthorizedUserPage {

    private SelenideElement nextButton = $(By.xpath("//a[@class='next btn btn-danger']")),
            searchField = $(By.xpath("//input[@class='find__input c-input']"));
    private ElementsCollection subjectItems = $$(By.xpath("//span[@class='check-item']"));
    private String expendSubjectButton = "preceding-sibling::div";
    private String subItems = "ancestor::div[@class='niche__body']//span";

    public CustomerProjectAddSubjectPage selectSubject(Subject subject) {
        subjectItems.findBy(text(subject.name().toLowerCase())).click();
        return this;
    }

    public CustomerProjectAddSubjectPage clickOnExpandSubjectListButton(Subject subject) {
        subjectItems.findBy(text(subject.name().toLowerCase())).
                $(By.xpath(expendSubjectButton))
                .click();
        return this;
    }

    public CustomerProjectAddSubjectPage enterInSearchField(String text) {
        searchField.shouldBe(visible).val(text);
        return this;
    }

    public CustomerProjectAddSubjectPage checkSubItemsList(String keyWord) {
        List<String> list = searchField.shouldBe(visible)
                .$$(By.xpath(subItems))
                .texts();
        list.forEach(s -> assertTrue(s.contains(keyWord)));
        return this;
    }

    public CustomerProjectAddContentTypePage pressNextButton() {
        nextButton.shouldBe(visible).click();
        return new CustomerProjectAddContentTypePage();
    }

}
