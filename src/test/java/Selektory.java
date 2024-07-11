import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Selektory {

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
    public void findElements() {
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
        agreeButton.click();
        WebElement searchField = driver.findElement(By.name("q"));

        searchField.sendKeys("omayo blogspot"); //wprowadzamy wartosc 'omayo blogspot' do pola
        searchField.sendKeys(Keys.ENTER); // wciskamy przycisk Enter

        driver.quit();
    }

    // testuję strone: https://omayo.blogspot.com/
    @Test
    public void testingOmayo() {
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        // ID
        By buttonId = By.id("alert1");
        WebElement ClickToGetAlert = driver.findElement(buttonId);

        // Name
        By ColumnName = By.name("Cross-Column"); // Pierwszy sposób
        WebElement CrossColumn = driver.findElement(ColumnName);

        WebElement CrossColumn2 = driver.findElement(By.name("Cross-Column")); // Drugi sposób

        //Class
        WebElement DayOfWeekAndDate = driver.findElement(By.className("date-header"));

        //TagName-input
        WebElement input = driver.findElement(By.tagName("input")); //dostajemy pierwszy element input jaki jest na stronie
        input.sendKeys("Judyta");

        List<WebElement> inputs = driver.findElements(By.tagName("input")); //znajdujemy wszystkie elementy na stronie, ktore spelniają kryteria wyszukiwania
        System.out.println("Ilosc inputów na stronie Omayo: " + inputs.size());

        //LinkText
        By linkText = By.linkText("jqueryui"); // Pierwszy sposób
        WebElement jqueryLink = driver.findElement(linkText);

        WebElement linkJquery = driver.findElement(By.linkText("jqueryui")); // Drugi sposób

        //PartialLinkText
        By partialLinkText = By.partialLinkText("jquer"); //Pierwszy sposób
        WebElement partialJqueryLink = driver.findElement(partialLinkText);

        WebElement partialLinkJquery = driver.findElement(By.partialLinkText("ryui")); //Drugi sposób

    }
}

