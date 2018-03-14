package cms.pages;

import cms.core.TestData;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class EditorHomePage extends AuthorHomePage {

    private SelenideElement projects = $(By.xpath(String.format(menuLocator, "1"))),
            people = $(By.xpath(String.format(menuLocator, "2"))),
            myWork = $(By.xpath(String.format(menuLocator, "3"))),
            myCv = $(By.xpath(String.format(menuLocator, "4")));

    private static String menuLocator = "//div[@class='menu']//li[%s]";

    public EditorHomePage checkEditorIsSignedIn() {
        checkUserIsLoggedIn(TestData.Editor.EDITOR_HOME_PAGE_URL, TestData.Editor.EDITOR_USER_NAME);
        checkEditorMenu();
        return this;
    }

    public EditorHomePage checkEditorIsSignedIn(String username) {
        checkUserIsLoggedIn(TestData.Editor.EDITOR_HOME_PAGE_URL, username);
        checkEditorMenu();
        return this;
    }

    private void checkEditorMenu() {
        projects.should(text(TestData.Editor.EDITOR_PROJECTS_TEXT));
        people.should(text(TestData.Editor.EDITOR_PEOPLE_TEXT));
        myWork.should(text(TestData.Editor.EDITOR_MY_WORK_TEXT));
        myCv.should(text(TestData.Editor.EDITOR_MY_CV_TEXT));
    }

}
