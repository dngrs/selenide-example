package cms.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static cms.core.TestData.Author.AUTHOR_HOME_PAGE_URL;
import static cms.core.TestData.Author.AUTHOR_MY_CV_TEXT;
import static cms.core.TestData.Author.AUTHOR_MY_JOBS_TEXT;
import static cms.core.TestData.Author.AUTHOR_MY_TASK_TEXT;
import static cms.core.TestData.Author.AUTHOR_MY_WORK_TEXT;
import static cms.core.TestData.Author.AUTHOR_USER_NAME;

@Getter
public class AuthorHomePage extends AuthorizedUserPage {

    private SelenideElement myWork = $(By.xpath("//div[@class='menu']//li[1]")),
            myCv = $(By.xpath("//div[@class='menu']//li[2]")),
            myTask = $(By.xpath("//div[@id='submenu']//li[1]")),
            myJobs = $(By.xpath("//div[@id='submenu']//li[2]"));

    public AuthorHomePage checkAuthorIsSignedIn() {
        checkUserIsLoggedIn(AUTHOR_HOME_PAGE_URL, AUTHOR_USER_NAME);
        checkAuthorMenu();
        return this;
    }

    public AuthorHomePage checkAuthorIsSignedIn(String username) {
        checkUserIsLoggedIn(AUTHOR_HOME_PAGE_URL, username);
        checkAuthorMenu();
        return this;
    }

    private void checkAuthorMenu() {
        myWork.should(text(AUTHOR_MY_WORK_TEXT));
        myCv.should(text(AUTHOR_MY_CV_TEXT));
        myTask.should(text(AUTHOR_MY_TASK_TEXT));
        myJobs.should(text(AUTHOR_MY_JOBS_TEXT));
    }

}
