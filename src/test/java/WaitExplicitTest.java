import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitExplicitTest {

    WebDriver driver;

    public WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "ie":
                return new InternetExplorerDriver();
            default:
                throw new InvalidArgumentException("Invalid browser name");
        }
    }

    @Test
    public void waitExplicitTest() {

        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));

        driver.findElement(By.cssSelector("p"));

    }
}
