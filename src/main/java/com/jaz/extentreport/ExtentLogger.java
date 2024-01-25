package com.jaz.extentreport;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.jaz.utils.ScreenshotIUtils;

public class ExtentLogger {

    public static void skip(String skipMessage)
    {
        ExtentManager.getExtentTest().skip(skipMessage);
    }
    public static void pass(String passMessage) {
        ExtentManager.getExtentTest().pass(passMessage);
    }

    public static void info(String info) {
        ExtentManager.getExtentTest().info(info);

    }

    public static void fail(String failMessage,boolean screenshotNeeded) {

        if(screenshotNeeded){
        ExtentManager.getExtentTest().fail(failMessage,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotIUtils.getBase64Image()).build()
        );}
        ExtentManager.getExtentTest().fail(failMessage);
    }
}
