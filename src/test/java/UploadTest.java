import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UploadTest {

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
    public void uploadFileTest() throws IOException {

        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        int randomNumber = (int) (Math.random()*1000); // unikalna nazwa screenshota

        //screenshot przed
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File before = screenshot.getScreenshotAs(OutputType.FILE);
        String beforeScreenshotName = "beforeUpload" + randomNumber + ".png"; // unikalna nazwa screenshota before
        FileUtils.copyFile(before,new File("src/test/resources/" + beforeScreenshotName)); // Make directory as Test Resources Root !!!

        // lokalizowanie i ścieżka
        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\Judyta\\Downloads\\Judyta-Odrobinska-CV.pdf");

        //screenshot po
        File after = screenshot.getScreenshotAs(OutputType.FILE);
        String afterScreenshotName = "afterUpload" + randomNumber + ".png"; // unikalna nazwa screenshota after
        FileUtils.copyFile(after,new File("src/test/resources/" + afterScreenshotName));

    }
}
