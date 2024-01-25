package com.jaz.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ExtentReportConfig {

    public static ExtentReports extent;
    public static ExtentSparkReporter spark;

    public static void initReport() {
        if (Objects.isNull(extent)) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
            LocalDateTime localDateTime = LocalDateTime.now();
            String dateTime = localDateTime.format(dateTimeFormatter).toString();
            String reportPath = "ExtentReport/index.html";
            extent = new ExtentReports();
            spark = new ExtentSparkReporter(reportPath);
            spark.config().setDocumentTitle("Docker-Final-Automation-Report");
            spark.config().setReportName("Docker-Test-Run-Results");
            spark.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss");
            extent.attachReporter(spark);

        }
    }

    public static void createTest(String testCaseName) {
        ExtentTest test = extent.createTest(testCaseName);
        ExtentManager.setExtentTest(test);

    }

    public static void flushReport() {
        if (Objects.nonNull(extent)) {
            ExtentManager.unloadExtentTest();
            extent.flush();
        }
    }
}
