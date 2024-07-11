import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.Test;

public class WebDriverManagerTest {

    @Test
    public void openBrowser() {
        //WebDriverManager.iedriver().setup();
        //InternetExplorerOptions options = new InternetExplorerOptions();
        //options.withInitialBrowserUrl("https://www.google.com");
        //WebDriver driver = new InternetExplorerDriver(options);

        /*
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false); // przegladarka otwiera sie jednak nie widzimy tego na ekranie
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT); //akceptacja alertow
        WebDriver driver = new ChromeDriver(options);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("allert('HelloAll')");
        driver.get("https://www.google.com");

         */

    }
}
