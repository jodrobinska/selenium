import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class SelektoryCSS {

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
    public void findElements () {
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        // jeżeli za pomocą CSS szukamy ID to korzystamy z #
        By cssId = By.cssSelector("#alert1"); // I Sposób
        driver.findElement(cssId);

        driver.findElement(By.cssSelector("#alert1")); // II Sposób

        // jeżeli klasa to korzystamy z kropki
        By cssClass = By.cssSelector(".date-header"); // Isposób
        driver.findElement(cssClass);

        driver.findElement(By.cssSelector(".date-header")); //IIsposób

        // jeżli tagname
        By cssTag = By.cssSelector("input"); // Isposób
        driver.findElement(cssTag).sendKeys("Judyta");


        driver.findElement(By.cssSelector("input")).sendKeys("Judyta"); // IIsposób

        // atrybut (np.name) = wartosc (Cross-Column)
        By cssName = By.cssSelector("[name='Cross-Column']"); //Isposob
        driver.findElement(cssName);

        driver.findElement(By.cssSelector("[name='Cross-Column']")); //IIsposob

        // atrybut = wartosc
        By cssClass1 = By.cssSelector("[class='date-header']"); //Isp
        driver.findElement(cssClass1);

        driver.findElement(By.cssSelector("[class='date-header']")); //IIsp

        //------------------------------------------------------------------------

        By all = By.cssSelector("*");
        driver.findElements(all);

        By ulInsideDiv = By.cssSelector("div ul");
        driver.findElement(ulInsideDiv);
        By trInTable = By.cssSelector("table tr");
        driver.findElement(trInTable);
        By trInBody = By.cssSelector("tbody tr");
        driver.findElement(trInBody);

        //--------------------------------------------------------------------------

        // selektor CSS ktory zawiera ciąg znaków (name='Cross-Column 2')
        By attributeContains = By.cssSelector("[name*='Column 2']");
        driver.findElement(attributeContains);

        // selektor CSS sprawdzajacy czy nazwa atrybutu rozpoczyna sie od konkretnej frazy (name='anyfile')
        By attributeStarts = By.cssSelector("[name^='anyf']");
        driver.findElement(attributeStarts);

        // selektor CSS sprawdzajacy czy ID atrybutu rozpoczyna sie od konkretnej frazy (id='sidebar-left-1')
        By attributeStarts1 = By.cssSelector("[id^='sideba']");
        driver.findElement(attributeStarts1);

        // wartość atrybutu kończy się konkretną frazą (name='Cross-Column 2')
        By attributeEnds = By.cssSelector("[name$='lumn 2']");
        driver.findElement(attributeEnds);

        //---------------------------------------------------------------

        // pierwsze dziecko tagu nadrzednego
        By firstChild = By.cssSelector("li:first-child");
        driver.findElement(firstChild);

        // ostatnie dziecko tagu nadrzednego
        By lastChild = By.cssSelector("li:last-child");
        driver.findElement(lastChild);

        // 5-te dziecko tagu nadrzednego (numerujemy od 1, nie od 0)
        By fifthChild = By.cssSelector("li:nth-child(5)");
        driver.findElement(fifthChild);
    }
}
