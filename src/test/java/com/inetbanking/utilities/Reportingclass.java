package com.inetbanking.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import freemarker.template.SimpleDate;
import junit.framework.Assert;
//this is a listener class USED TO GENERTE EXTENT REPORTS
public class Reportingclass extends TestListenerAdapter {
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeTest
	public void startReport() {
		String timestamp = new SimpleDateFormat("dd.MM.YYYY.HH.mm.ss").format(new Date());
		// this will generate date will be genrated
		String repName = "Test-Report" + timestamp + ".html";
		// this will be reportname wit timestamp

		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + repName);
		// specfiying the location of to store the report with above format of repNma

		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/MYSTORE.html", true);
		extent.addSystemInfo("Host Name", "LocalHost");
		extent.addSystemInfo("Environment", "QA");
		extent.addSystemInfo("User Name", "Manjula");
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		
		
		htmlreporter.config().setDocumentTitle("mystoreproject");
		htmlreporter.config().setReportName("Fucntional test report");
		htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlreporter.config().setTheme(Theme.DARK);
	}

	@Test
	public void demoReportPass() {
		test = extent.startTest("demoreportPass");
		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "assert pass as condition true");
	}

	@Test
	public void demoReportFail() {
		test = extent.startTest("demoreportFail");
		Assert.assertTrue(false);
		test.log(LogStatus.FAIL, "assert fail as condition fail");
		
		
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getThrowable());
		}
		extent.endTest(test);
	}

	@AfterTest
	public void endreport() {
		extent.flush();
		// these will clear the memory
	}
}
