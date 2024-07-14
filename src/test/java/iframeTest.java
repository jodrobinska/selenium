import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class iframeTest {

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
    public void testiframe() {

        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");

        //driver.switchTo().frame(0); // przełączamy się do iframe (I metoda - index)

        WebElement iframe = driver.findElement(By.cssSelector("[src='basics.html']")); // przełączamy się do iframe (II metoda - WebElement)
        driver.switchTo().frame(iframe);

        //driver.switchTo().frame("id lub name"); // przełączamy się do iframe (III metoda - jesli posiadamy name lub id)

        driver.findElement(By.id("fname")).sendKeys("Judyta");

        driver.switchTo().defaultContent(); // aby otrzymać text z h1 'To jest iframe' musimy przepiąć się do pierwszego okna
        System.out.println(driver.findElement(By.tagName("h1")).getText());

    }
}
