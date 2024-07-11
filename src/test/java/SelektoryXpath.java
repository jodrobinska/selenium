import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelektoryXpath {

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

    // testuję strone: https://omayo.blogspot.com/ ; 05.07.2024
    @Test
    public void testingOmayoPage() {
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        // ID
        By buttonId = By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/aside/div[1]/div[4]/div[1]/input");
        WebElement ClickToGetAlert = driver.findElement(buttonId);

        By buttonId1 = By.xpath("//*[@id='alert1']");
        WebElement ClickToGetAlert1 = driver.findElement(buttonId1);

        driver.findElement(By.xpath("//button[@id='but1']"));

        // Name
        By ColumnName = By.xpath("//*[@name='Cross-Column']"); // Pierwszy sposób
        WebElement CrossColumn = driver.findElement(ColumnName);

        WebElement CrossColumn2 = driver.findElement(By.xpath("//*[@name='Cross-Column']")); // Drugi sposób

        //Class
        WebElement DayOfWeekAndDate = driver.findElement(By.xpath("//*[@class='date-header']"));

        //TagName-input
        WebElement input = driver.findElement(By.xpath("//input")); //dostajemy pierwszy element input jaki jest na stronie
        input.sendKeys("JJudyta");

        List<WebElement> inputs = driver.findElements(By.tagName("input")); //znajdujemy wszystkie elementy na stronie, ktore spelniają kryteria wyszukiwania
        System.out.println("Ilosc inputów na stronie Omayo: " + inputs.size());


        //LinkText, wyszukiwanie elementow po tekscie
        By linkText = By.xpath("//a[text()='jqueryui']"); // Pierwszy sposób
        WebElement jqueryLink = driver.findElement(linkText);

        WebElement linkJquery = driver.findElement(By.xpath("//a[text()='jqueryui']")); // Drugi sposób

        //PartialLinkText, mając część tekstu
        By partialLinkText = By.xpath("//a[contains(text(),'jquer')]"); //Pierwszy sposób
        WebElement partialJqueryLink = driver.findElement(partialLinkText);

        WebElement partialLinkJquery = driver.findElement(By.xpath("//a[contains(text(),'ryui')]")); //Drugi sposób


        // FULL Xpath
        By fullPath = By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/aside/div[1]/div[2]/div[1]/div/form/table/tbody/tr/td[2]/input");
        driver.findElement(fullPath);


        // Xpath z //
        By shortPath = By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/aside//tr/td[2]/input");
        driver.findElement(shortPath);

        // short path
        By shortPath1 = By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/aside//input");
        driver.findElement(shortPath1);

        // short path
        By shortPath2 = By.xpath("//input");
        driver.findElement(shortPath2);


        //wszystkie elementy button
        driver.findElement(By.xpath("//button"));

        //drugi element typu button
        driver.findElement(By.xpath("(//button)[2]"));

        //wszystkie elementy ktore mają ID
        driver.findElement(By.xpath("//*[@id]"));

        //wszystkie inputy ktore mają ID
        driver.findElement(By.xpath("//input[@id]"));

        // pierwszy element input który posiada ID
        driver.findElement(By.xpath("(//input[@id])[1]"));

        By inputID = By.xpath("(//input[@id])[1]");
        WebElement input01 = driver.findElement(inputID);
        input01.clear();
        input01.sendKeys("abc");

        // ostatni element input który posiada ID
        driver.findElement(By.xpath("(//input[@id])[last()]"));

        // name "Cross-Column" atrybutu zawiera
        driver.findElement(By.xpath("//*[contains(@name,'oss-Column')]"));

        // name "Cross-Column" atrybutu rozpoczyna się  "Cross-Co"
        driver.findElement(By.xpath("//*[starts-with(@name,'Cross-Co')]"));

        // wszystkie inputy znajdujące się na stronie
        driver.findElement(By.xpath("//input"));

        // wszystkie linki znajdujące się na stronie
        driver.findElement(By.xpath("//a"));

        // wszystkie linki oraz inputy znajdujące się na stronie
        driver.findElement(By.xpath("//a | //input"));

        // wszystkie linki oraz divy zawierające ul
        driver.findElement(By.xpath("//a | //div//ul"));

        // input dla którego name to: userid
        driver.findElement(By.xpath("//input[@name='userid']"));

    }
}

