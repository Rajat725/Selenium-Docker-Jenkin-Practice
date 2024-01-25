package com.jaz.extentreport;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

    public static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    public static void setExtentTest(ExtentTest extentTest) {
        extentTestThreadLocal.set(extentTest);
    }

    public static ExtentTest getExtentTest() {
        return extentTestThreadLocal.get();
    }

    public static void unloadExtentTest() {
        extentTestThreadLocal.remove();
    }


}
