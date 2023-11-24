package tests;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;

/**
 * Запускает браузер Chrome с настроенным профилем.
 * Плагины браузера(Add-ons) автоматом добавлятся, если поместисть файлы (*.crx) в /src/main/resources/extensions
 * Драйвер браузера автоматически загружается и прописывается в classPath
 */
public class ChromeDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        WebDriverManager.chromedriver().driverVersion("119.0").setup();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        ChromeDriver driver = new ChromeDriver(options);

        System.setProperty("browser", driver.getCapabilities().getBrowserName());
        System.setProperty("driver.version", driver.getCapabilities().getBrowserVersion());
        System.out.println(System.getProperty("browser"));
        System.out.println(System.getProperty("driver.version"));

        return driver;

    }

}
