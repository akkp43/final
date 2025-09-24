package com.mystore.utility;

import java.io.IOException;

import org.apache.logging.log4j.util.Cast;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;


public class ListenerClass implements ITestListener {

	//Action action= new Action();
	
	private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Pass Test case is: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            test.get().log(Status.FAIL,
                    MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            test.get().log(Status.FAIL,
                    MarkupHelper.createLabel(result.getThrowable().toString(), ExtentColor.RED));

            // Capture screenshot
            String imgPath = Action.screenShot(BaseClass.getDriver(), result.getName());
            test.get().fail("Screenshot is Attached",
                    MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Skipped Test case is: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
