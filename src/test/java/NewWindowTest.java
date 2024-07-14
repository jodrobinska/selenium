import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindowTest {

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
    public void testNewWindow() {

        // testuję: https://testeroprogramowania.github.io/selenium/basics.html

        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        String currentWindow = driver.getWindowHandle(); // nazwa pierwszego okna!

        driver.findElement(By.id("newPage")).click(); // klikamy na element

        Set<String> windowNames = driver.getWindowHandles();
        for(String window : windowNames){
            if(!window.equals(currentWindow)) {
                driver.switchTo().window(window);
            }
        }

        By zaakceptuj = By.xpath("//*[@id='L2AGLb']/div"); // Znajdujemy 'Zaakceptuj wszystko' i klikamy
        WebElement ClickAkceptuj = driver.findElement(zaakceptuj);
        ClickAkceptuj.click();

        driver.manage().window().maximize();
        WebElement google = driver.findElement(By.name("q"));
        google.sendKeys("Selenium");
        google.sendKeys(Keys.ENTER);

        driver.switchTo().window(currentWindow); // przepinamy się do pierwszego okna
        driver.findElement(By.name("fname")).sendKeys("Jodie");

    }
}
