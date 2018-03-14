package cms.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static cms.core.TestData.PrivacyPolicy.PRIVACY_POLICY_PAGE_HEADER;
import static cms.core.TestData.PrivacyPolicy.PRIVACY_POLICY_PAGE_PATH;
import static org.testng.AssertJUnit.assertTrue;

@Getter
public class PrivacyPolicyPage {

    private SelenideElement pageHeader = $(By.xpath("//h1"));

    public PrivacyPolicyPage checkUserIsOnPrivacyPolicyPage() {
        pageHeader.shouldBe(visible).val().equals(PRIVACY_POLICY_PAGE_HEADER);
        assertTrue(url().equals(PRIVACY_POLICY_PAGE_PATH));
        return this;
    }

}
