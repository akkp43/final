package com.mystore.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
/**
 *  
 */
public class ExtentManager {
	
	 private static ExtentReports extent;

	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            String reportPath = System.getProperty("user.dir") +
	                                "\\test-output\\ExtentReport\\MyReport.html";
	            String configPath = System.getProperty("user.dir") +
	                                "\\test-output\\extent-config.xml";

	            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
	            htmlReporter.loadXMLConfig(configPath);

	            extent = new ExtentReports();
	            extent.attachReporter(htmlReporter);

	            extent.setSystemInfo("HostName", "MyHost");
	            extent.setSystemInfo("ProjectName", "MyStoreProject");
	            extent.setSystemInfo("Tester", "Akshay");
	            extent.setSystemInfo("OS", "Win10");
	            extent.setSystemInfo("Browser", "Chrome");
	        }
	        return extent;
	    }
	    public static void endReport() {
	        if (extent != null) {
	            extent.flush();
	        }
	    }}
	        
