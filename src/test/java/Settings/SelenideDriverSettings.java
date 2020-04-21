package Settings;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public abstract class SelenideDriverSettings {

    @BeforeClass
    public void setupBrowser() {
        Configuration.browser = "chrome";
    }
}
