package cms.pages.customer;

import cms.pages.AuthorizedUserPage;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class CustomerProjectAddPage extends AuthorizedUserPage {

    private SelenideElement projectNameField = $(By.xpath("//input[@class='projectname']")),
            ruLanguage = $(By.xpath("(//div[@class='clearfix lang-item bold'])[1]")),
            nextButton = $(By.xpath("//a[@class='next btn btn-danger']"));

    public CustomerProjectAddPage enterProjectName(String projectName) {
        projectNameField.shouldBe(visible).val(projectName);
        return this;
    }

    public CustomerProjectAddPage selectLanguage(SelenideElement language) {
        language.shouldBe(visible).click();
        return this;
    }

    public CustomerProjectAddSubjectPage pressNextButton() {
        nextButton.shouldBe(visible).click();
        return new CustomerProjectAddSubjectPage();
    }

}
