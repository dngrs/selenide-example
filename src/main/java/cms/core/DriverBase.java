package cms.core;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class DriverBase {

    @BeforeMethod
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(TestData.General.PROXY_CHROME_HOST_CONF);
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1440, 990));
        driver.manage().timeouts().implicitlyWait(TestData.Selenide.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(TestData.Selenide.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TestData.Selenide.TIMEOUT, TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }

}
