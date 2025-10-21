package tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1980x1020");
//        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
//        Configuration.remote = System.getProperty("remote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
//        Configuration.holdBrowserOpen = false;

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//        Configuration.browserCapabilities = capabilities;
    }

//    @BeforeEach
//    public void addListener() {
//        SelenideLogger.addListener("allure", new AllureSelenide());
//    }

//    @AfterEach
//    public void tearDown() {
//        Attach.screenShotAs("Last screenshot");
//        Attach.pageSource();
//        Attach.browserConsoleLogs();
//        Attach.addVideo();
//    }
}