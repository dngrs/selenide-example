package cms.core;


import cms.util.PropertiesCache;

import static cms.core.TestData.General.CG_URL;

public class TestData {

    public static class Selenide {
        public static final long TIMEOUT = Long.parseLong(PropertiesCache.getProperty("selenide.timeout")),
                WAIT_UNTIL = Long.parseLong(PropertiesCache.getProperty("selenide.wait.until"));
    }

    public static class General {
        public static final String CG_URL = PropertiesCache.getProperty("base.cg.url"),
                PROXY_CHROME_HOST_CONF = PropertiesCache.getProperty("proxy.chrome.host.conf");
    }

    public static class Login {
        public static final String LOGIN_PAGE_URL = CG_URL + PropertiesCache.getProperty("login.page.path"),
                LOGIN_PAGE_TITLE = PropertiesCache.getProperty("login.page.title"),
                LOGIN_GET_STARTED_BUTTON_TEXT = PropertiesCache.getProperty("login.get.started.button.text"),
                LOGIN_FORM_HEADER_TEXT = PropertiesCache.getProperty("login.form.header.text"),
                LOGIN_SIGNIN_BUTTON_TEXT = PropertiesCache.getProperty("login.signin.button.text"),
                LOGIN_FORGOT_PASSWORD_TEXT = PropertiesCache.getProperty("login.forgot.password.text"),
                LOGIN_FORM_ERROR_MESSAGE = PropertiesCache.getProperty("login.form.error.message");

    }

    public static class Registration {
        public static final String REGISTRATION_PAGE_URL = CG_URL + PropertiesCache.getProperty("registration.page.path"),
                REGISTRATION_EMAIL_CG_LINK = PropertiesCache.getProperty("registration.email.cg.link"),
                REGISTRATION_INVITE_KEY = PropertiesCache.getProperty("registration.invite.key"),
                REGISTRATION_INVALID_INVITE_KEY = PropertiesCache.getProperty("registration.invalid.invite.key"),
                REGISTRATION_VALID_USERNAME = PropertiesCache.getProperty("registration.valid.username"),
                REGISTRATION_INVALID_USERNAME = PropertiesCache.getProperty("registration.invalid.username"),
                REGISTRATION_VALID_EMAIL = PropertiesCache.getProperty("registration.valid.email"),
                REGISTRATION_INVALID_EMAIL = PropertiesCache.getProperty("registration.invalid.email"),
                REGISTRATION_DEFAULT_PASSWORD = PropertiesCache.getProperty("registration.default.password"),
                REGISTRATION_INVALID_PASSWORD = PropertiesCache.getProperty("registration.invalid.password");

    }

    public static class Author {
        public static final String AUTHOR_HOME_PAGE_URL = CG_URL + PropertiesCache.getProperty("author.page.path"),
                AUTHOR_USER_NAME = PropertiesCache.getProperty("author.username"),
                AUTHOR_EMAIL = PropertiesCache.getProperty("author.email"),
                AUTHOR_PASSWORD = PropertiesCache.getProperty("author.password"),
                AUTHOR_MY_WORK_TEXT = PropertiesCache.getProperty("author.my.work.text"),
                AUTHOR_MY_CV_TEXT = PropertiesCache.getProperty("author.my.cv.text"),
                AUTHOR_MY_TASK_TEXT = PropertiesCache.getProperty("author.my.task"),
                AUTHOR_MY_JOBS_TEXT = PropertiesCache.getProperty("author.my.jobs.text");
    }

    public static class Customer {
        public static final String CUSTOMER_HOME_PAGE_URL = CG_URL + PropertiesCache.getProperty("customer.page.path"),
                CUSTOMER_USER_NAME = PropertiesCache.getProperty("customer.username"),
                CUSTOMER_USER_NAME_TEST = PropertiesCache.getProperty("customer.username.test"),
                CUSTOMER_EMAIL = PropertiesCache.getProperty("customer.email"),
                CUSTOMER_EMAIL_TEST = PropertiesCache.getProperty("customer.email.test"),
                CUSTOMER_PASSWORD = PropertiesCache.getProperty("customer.password"),
                CUSTOMER_PEOPLE_TEXT = PropertiesCache.getProperty("customer.people.text"),
                CUSTOMER_PROJECTS_TEXT = PropertiesCache.getProperty("customer.projects.text"),
                CUSTOMER_PAGE_TITLE = PropertiesCache.getProperty("customer.title.text"),
                CUSTOMER_EMAIL_UNREGISTERED = PropertiesCache.getProperty("customer.email.unregistered"),
                CUSTOMER_PASSWORD_INCORRECT = PropertiesCache.getProperty("customet.password.incorrect"),
                CUSTOMER_EMAIL_EMPTY = PropertiesCache.getProperty("customer.email.empty"),
                CUSTOMER_PASSWORD_EMPTY = PropertiesCache.getProperty("customer.password.empty"),
                CUSTOMER_PROJECT_TEST_NAME = PropertiesCache.getProperty("customer.projects.test.name"),
                CUSTOMER_PROJECT_SUBJECT_SEARCH_TEXT = PropertiesCache.getProperty("customer.projects.subject.search.text");
    }

    public static class Editor {
        public static final String EDITOR_HOME_PAGE_URL = CG_URL + PropertiesCache.getProperty("editor.page.path"),
                EDITOR_USER_NAME = PropertiesCache.getProperty("editor.username"),
                EDITOR_EMAIL = PropertiesCache.getProperty("editor.email"),
                EDITOR_PASSWORD = PropertiesCache.getProperty("editor.password"),
                EDITOR_PEOPLE_TEXT = PropertiesCache.getProperty("editor.people.text"),
                EDITOR_PROJECTS_TEXT = PropertiesCache.getProperty("editor.projects.text"),
                EDITOR_MY_WORK_TEXT = PropertiesCache.getProperty("editor.my.work.text"),
                EDITOR_MY_CV_TEXT = PropertiesCache.getProperty("editor.my.cv.text");
    }

    public static class UserProfilePopup {
        public static final String VIEW_PROFILE_BUTTON_TEXT = PropertiesCache.getProperty("view.profile.button.text"),
                SETTINGS_LINK_TEXT = PropertiesCache.getProperty("settings.link.text"),
                LOGOUT_LINK_TEXT = PropertiesCache.getProperty("logout.link.text");
    }

    public static class MyProfile {
        public static final String URL = CG_URL + PropertiesCache.getProperty("page.path"),
                MY_PROFILE_TEXT = PropertiesCache.getProperty("my.profile.text"),
                CHANGE_PASSWORD_TEXT = PropertiesCache.getProperty("change.password.text"),
                PROFESSIONAL_SKILLS_TEXT = PropertiesCache.getProperty("professional.skills.text");
    }

    public static class TempMail {
        public static final String TEMP_MAIL_URL = PropertiesCache.getProperty("temp.mail.url"),
                TEMP_MAIL_TITLE = PropertiesCache.getProperty("temp.mail.title"),
                TEMP_MAIL_MESSAGE_TITLE = PropertiesCache.getProperty("temp.mail.message.title"),
                TEMP_MAIL_MESSAGE_LINK_TEXT = PropertiesCache.getProperty("temp.mail.message.link.text");
        public static final long TEMP_MAIL_WAIT = Long.parseLong(PropertiesCache.getProperty("temp.mail.wait"));
    }

    public static class PrivacyPolicy {
        public static final String PRIVACY_POLICY_PAGE_PATH = PropertiesCache.getProperty("privacy.policy.page.path"),
                PRIVACY_POLICY_PAGE_HEADER = PropertiesCache.getProperty("privacy.policy.page.header");
    }

}
