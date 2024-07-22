package pl.testowanie;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

    WebDriver driver;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am starting Test Listener");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Success of test cases and its details are: ");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        driver = DriverFactory.getDriver();

        int randomNumber = (int) (Math.random()*1000); // unikalna nazwa screenshota

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File before = screenshot.getScreenshotAs(OutputType.FILE);
        String fileName = "failedTest" + randomNumber + ".png"; // unikalna nazwa screenshota before
        try {
            FileUtils.copyFile(before,new File("src/test/resources/" + fileName)); // Make directory as Test Resources Root !!!
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Skip of test cases and its details are : ");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Failure of test cases and its details are : ");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }

}
