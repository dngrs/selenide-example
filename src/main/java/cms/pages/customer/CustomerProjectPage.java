package cms.pages.customer;

import com.codeborne.selenide.SelenideElement;
import cms.pages.AuthorizedUserPage;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class CustomerProjectPage extends AuthorizedUserPage {

    private SelenideElement addProjectButton = $(By.xpath("//a[@class='btn btn-danger add-project']"));
    private String projectMenu = "//h2/a[contains(text(), '%s')]/../../.././/div[@class='actions']";
    private String deleteProject = "//h2/a[contains(text(), '%s')]/../../.././/div[@class='actions']"
            + "//span[@class='project-action delete']";

    public CustomerProjectAddPage pressAddProjectButton() {
        addProjectButton.shouldBe(visible).click();
        return new CustomerProjectAddPage();
    }

    public CustomerProjectPage deleteProject(String project) {
        $(By.xpath(String.format(projectMenu, project)))
                .shouldBe(visible)
                .click();
        $(By.xpath(String.format(deleteProject, project)))
                .shouldBe(visible)
                .click();
        return this;
    }

}
