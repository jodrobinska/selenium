import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {

/*
@Test
public void openGooglePagewithChrome() {
    WebDriver driver = new ChromeDriver();
    //String path = "C:\\Users\\Judyta\\Downloads\\chromedriver-win64\\chromedriver.exe";
    driver.get("https://www.google.com/");
}

@Test
public void openGooglePage() {
    WebDriver driver = new FirefoxDriver();
    driver.get("https://www.google.com/");
}

@Test
public void openGooglePagewithInternetExplorer() {
    WebDriver driver = new InternetExplorerDriver();
    driver.get("https://www.google.com/");
}
*/

public WebDriver getDriver(String browser){
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
 /*public void openPageGoogle() {
    WebDriver driver = getDriver("chrome");
    driver.manage().window().maximize(); //aby przegladarka zajela caly ekran
    //Dimension windowSize = new Dimension(300, 500); //wybieramy rozmiar okna przegladarki
    //driver.manage().window().setSize(windowSize); //nastepnie przesylamy do metody
    driver.get("https://www.google.com/");

    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("window.open('https://www.jetbrains.com/idea/','blank','height=700,width=700')");

    //driver.quit(); //zamyka oba okna
    driver.close(); //zamyka pierwotne okno, drugie pozostaje otwarte   */

//Test
public void openPageGoogle() {
    WebDriver driver = getDriver("chrome");
    driver.manage().window().maximize();
    driver.get("https://www.google.com/");

    WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']")); //akceptujemy cookie
    agreeButton.click(); // klikniecie przycisku
    WebElement searchField = driver.findElement(By.name("q")); //znajdujemy pole wyszukiwania
    searchField.sendKeys("Selenium"); //wprowadzamy wartosc Selenium do pola
    searchField.sendKeys(Keys.ENTER); // wciskamy przycisk Enter

    WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));

    Assert.assertTrue(result.isDisplayed());

}
}
