/**
 * 
 */
package com.notesapi.extentreport;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

/**
 * @author Santosh Sharma
 *
 */
public class ReportManager {
	
	public static ExtentSparkReporter spark;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public static void reportSetUp() {
		
		String dateTime = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss").format(new Date());
		String fileName = "Test-Report_ " + dateTime + ".html";
		String fullPath = System.getProperty("user.dir") + "/reports/" + fileName;
		
		spark = new ExtentSparkReporter(fullPath);
		spark.config().setReportName("Test Execution Report");
		spark.config().setTheme(Theme.DARK);
		spark.config().setEncoding("UTF-8");
		spark.viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.AUTHOR,
				ViewName.DEVICE, ViewName.EXCEPTION }).apply();
		
		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Project Name", "Notes-Api-Framework");
		reports.setSystemInfo("Base URL", "https://practice.expandtesting.com/notes/api");
		reports.setSystemInfo("Java", System.getProperty("java.version"));
	}

}
