import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class BasicActionsTest {

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
    public void performAction() {

        // testuję: https://testeroprogramowania.github.io/selenium/

        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/");

        WebElement podstStrTestLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        podstStrTestLink.click();

        //driver.findElement(By.id("clickOnMe")).click();
        driver.findElement(By.id("fname")).sendKeys("Judyta");

        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.clear();
        usernameInput.sendKeys("Judyta29");
        usernameInput.sendKeys(Keys.TAB);

        WebElement passInput = driver.findElement(By.name("password"));
        passInput.sendKeys(Keys.TAB);
        //passInput.sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector("[type='checkbox']")).click(); // checkbox

        driver.findElement(By.cssSelector("[value='female']")).click(); // radiobutton



    }
}
