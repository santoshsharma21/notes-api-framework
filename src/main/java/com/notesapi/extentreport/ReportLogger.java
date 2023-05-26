/**
 * 
 */
package com.notesapi.extentreport;

import java.util.List;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.restassured.http.Header;

/**
 * @author Santosh Sharma
 *
 */
public class ReportLogger {
	
	public static void logInfoDetails(String log) {
		ReportManager.test.info(MarkupHelper.createLabel(log, ExtentColor.GREY));
	}
	
	public static void logJsonDetails(String json) {
		ReportManager.test.info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
	}
	
	public static void logHeaderInTableFormat(List<Header> headerList) {
		String[][] headerArray = headerList.stream().map(header -> new String[] {header.getName(), header.getValue()})
				.toArray(String [][] :: new);
		ReportManager.test.info(MarkupHelper.createTable(headerArray));
	}
	
}
