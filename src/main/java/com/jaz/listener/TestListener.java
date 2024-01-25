package com.jaz.listener;

import com.jaz.driver.DriverManager;
import com.jaz.extentreport.ExtentLogger;
import com.jaz.extentreport.ExtentManager;
import com.jaz.extentreport.ExtentReportConfig;
import org.testng.*;

public class TestListener implements ITestListener, ISuiteListener {
    @Override
    public void onTestStart(ITestResult result) {
       ExtentReportConfig.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ISuite suite) {
        ExtentReportConfig.initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReportConfig.flushReport();
        DriverManager.unload();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName(),false);
        ExtentLogger.fail(result.getThrowable().getMessage(),true);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
