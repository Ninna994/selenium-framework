package Academy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReporter;
import resources.base;

import java.io.IOException;

public class Listeners extends base implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReporter.getReportObject();
    // for parallel usage
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();



    @Override
    public void onTestStart(ITestResult result) {
        // extent reporting with dynamic method name
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test); // to support parallel execution
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // extent report
        extentTest.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // extent report
        extentTest.get().fail(result.getThrowable()); // to support parallel execution


        // all other code in base.java getScreenshotPath function
        // capture the name of test that failed
        String testMethodName = result.getMethod().getMethodName();
//        capture driver field
        WebDriver driver = null;
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        try {
            // add screenshot to report
            extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testMethodName, driver) ,result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Screenshot method

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        // last event to be executed - flush extent reporter
        extent.flush();
    }
}
