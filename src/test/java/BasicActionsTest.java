import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

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

        // pobieranie wpisanej wpisanej przez użytkownika wartości z pola tekstowego
        System.out.println(usernameInput.getAttribute("value"));

        WebElement passInput = driver.findElement(By.name("password"));
        passInput.sendKeys(Keys.TAB);
        passInput.sendKeys(Keys.ENTER); //pokazuje się alert
        Alert firstAlert = driver.switchTo().alert(); // przepinamy się do alertu
        firstAlert.accept();
        driver.switchTo().alert().accept(); // przepinamy się do drugiego alertu


        driver.findElement(By.cssSelector("[type='checkbox']")).click(); // checkbox

        driver.findElement(By.cssSelector("[value='female']")).click(); // radiobutton

        // select Volvo,Saab,Mercedes,Audi
        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        Select cars4 = new Select(selectCar);
        //cars4.selectByIndex(2); // 1sp; numerujemy od 0
        //cars4.selectByVisibleText("Audi"); // 2sp; ważna jest wielkość liter
        cars4.selectByValue("saab"); // 3sp

        // wypisujemy opcje z selecta
        List<WebElement> options4 = cars4.getOptions();
        for (WebElement option : options4) {
            System.out.println(option.getText()); // metoda getText działa dla kazdego WebElementu
        }

        SelectCheck selectCheck = new SelectCheck();
        System.out.println(selectCheck.checkOption("Saab",selectCar));
        System.out.println(selectCheck.checkOption("VW",selectCar));


        // pobieranie wartości ukrytej na stronie
        WebElement paraHidden = driver.findElement(By.className("topSecret"));
        System.out.println("By attr text content: " + paraHidden.getAttribute("textContent"));

    }
}
