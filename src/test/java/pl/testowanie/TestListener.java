package pl.testowanie;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

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
        System.out.println("I am taking screenshot, it is fail");
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
