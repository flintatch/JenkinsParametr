package tests;

import Assisst.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;


public class TestBase {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        String browserName = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browser_version", "100");
        String browserSize = System.getProperty("browser_size", "1920*1080");
        String remoteUrl= System.getProperty("remote_url", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        if (!System.getProperty().equals("")) {
            Configuration.remote = System.getProperty.remoteUrl();
        }
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}