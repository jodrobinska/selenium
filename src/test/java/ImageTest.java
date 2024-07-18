import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImageTest {

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
    public void imageTest() {

        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/image.html");


        //sprawdzenie w konsoli
        //WebElement image = driver.findElement(By.id("smileImage"));
        //System.out.println(image.getAttribute("naturalHeight")); // nie załadowany więc otrzymujemy wartość o

        //sprawdzenie poprzez asercję
        WebElement image = driver.findElement(By.id("smileImage"));
        String height = image.getAttribute("naturalHeight");

        Assert.assertEquals(height,"0"); // passed jeśli 0 niezaładowany, fail ponieważ obrazek załadowany

    }

}
