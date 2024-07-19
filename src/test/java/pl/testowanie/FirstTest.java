package pl.testowanie;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class FirstTest {

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
    public void firstTest() {

        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();
        waitForElementToExist(By.cssSelector("p"));

        // ASERCJE TWARDE - spr i przerwanie testu jesli fail
        WebElement para = driver.findElement(By.cssSelector("p")); // Asercje II sposób
        Assert.assertEquals(para.isDisplayed(),true); //dziwny zapis
        Assert.assertTrue(para.isDisplayed());
        Assert.assertTrue(para.getText().startsWith("Dopiero"));
        Assert.assertFalse(para.getText().startsWith("Pojawiłem"));

        String paraText = driver.findElement(By.cssSelector("p")).getText(); // Asercje I sposób
        Assert.assertEquals(paraText,"Dopiero","Teksty są różne"); // fail z informacją 'Teksty są różne'
        Assert.assertEquals(paraText,"Dopiero się pojawiłem!");
        driver.quit();
    }

    @Test
    public void secondTest() {

        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();
        waitForElementToExist(By.cssSelector("p"));

        // ASERCJE MIEKKIE - spr wszystko
        WebElement para = driver.findElement(By.cssSelector("p")); // Asercje II sposób

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(para.isDisplayed(),true); //dziwny zapis
        softAssert.assertTrue(para.isDisplayed(),"Element is not dosplayed");
        //softAssert.assertEquals(para.getText(),"Dopiero","Teksty są różne - fail"); //fail
        softAssert.assertTrue(para.getText().startsWith("Dopiero"));
        softAssert.assertFalse(para.getText().startsWith("Pojawiłem"));
        //softAssert.assertEquals(para.getText(),"Dopiero się","Drugi fail"); //fail

        driver.quit();
        softAssert.assertAll();
    }



    public void waitForElementToExist(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        wait.until((driver) -> {
            List<WebElement> elements = driver.findElements(locator);
            if(elements.size()>0) {
                System.out.println("Element jest na stronie");
                return true;
            } else {
                System.out.println("Elementu nie ma na stronie");
                return false;
            }
        });
    }
}
