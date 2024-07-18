import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class ElementExistTest {

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
    public void elementExistTest() {

        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // sprawdzenie czy element istnieje na stronie
        System.out.println(elementExist(By.tagName("p"))); //true
        System.out.println(elementExist(By.id("fname"))); //true
        System.out.println(elementExist(By.id("fnaame"))); //false

        //-------------------

        //spradzenie czy element jest widoczny dla użytkownika
        System.out.println(driver.findElement(By.tagName("p")).isDisplayed()); //jest ukryty - false
        System.out.println(driver.findElement(By.tagName("button")).isDisplayed()); // widoczny - true

        //--------------------

        //sprawdzenie czy element jest aktywny (czy wyszarzony)
        System.out.println(driver.findElement(By.tagName("button")).isEnabled()); // aktywny - true

        //---------------------

        //sprawdzenie czy checkbox jest zaznaczony
        System.out.println("==========");
        WebElement checkboxInput = driver.findElement(By.cssSelector("[type='checkbox']"));
        System.out.println(checkboxInput.isSelected());  //false - nie zaznaczony
        checkboxInput.click();
        System.out.println(checkboxInput.isSelected()); //true - zaznaczony

    }


    //sprawdzenie czy element istnieje na stronie
    public boolean elementExist(By locator) {

        return driver.findElements(locator).size() > 0;
    }
}
