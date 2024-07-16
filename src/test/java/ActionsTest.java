import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest {

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
    public void actionsTesting() {

        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");

        // klikanie prawym przyciskiem myszy w przypadkowe miejsce
        Actions actions = new Actions(driver);
        //actions.contextClick().perform();

        // kilknięcie prawym w input, id = 'myFile'
        //actions.contextClick(driver.findElement(By.id("bottom"))).perform();

        // podwójne kliknięcie
        WebElement ClickMeTwice = driver.findElement(By.id("bottom"));
        actions.doubleClick(ClickMeTwice).perform();

    }
}
