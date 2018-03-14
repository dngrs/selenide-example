package cms.util;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Helper {

    public static void openInNewTab(String url) {
        executeJavaScript("window.open('" + url + "','_blank');");
    }

    public static String generateUsernameFromEmail(String email) {
        return email.split("@")[0];
    }

}
