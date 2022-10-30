package tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTest {

    @Test
    @Tag("many_properties_test")
    void simplePropertyTest() {
        String browserName = System.getProperty("browser", "edge");
        String browserVersion = System.getProperty("browser_version", "100");
        String browserSize = System.getProperty("browser_size", "1920x1080");
        String remoteUrl = System.getProperty("remote_Url", "");

        System.out.println(browserName);
        System.out.println(browserVersion);
        System.out.println(browserSize);
        System.out.println(remoteUrl);

    }
}
