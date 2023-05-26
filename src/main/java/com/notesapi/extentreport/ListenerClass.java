/**
 * 
 */
package com.notesapi.extentreport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

/**
 * @author Santosh Sharma
 *
 */
public class ListenerClass extends ReportManager implements ITestListener {
	
	@Override
	public void onStart(ITestContext context) {
		reportSetUp();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getTestClass().getName() + " - " + result.getMethod().getMethodName());
		test.assignAuthor("Santosh");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - TEST PASSED", ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,MarkupHelper.createLabel(result.getName() + " - TEST FAILED", ExtentColor.RED));
		test.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable().getMessage(), ExtentColor.RED));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,MarkupHelper.createLabel(result.getName() + " - TEST SKIPED", ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}
	
	
}
