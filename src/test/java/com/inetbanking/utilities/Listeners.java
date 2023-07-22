package com.inetbanking.utilities;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter {
		
		public void onTestStart(ITestResult ir)
		{
			System.out.println("test started");
		}
		
		public void onTestFailure(ITestResult ir)
		{
			System.out.println("test started");
		}
		public void onTestSkipped(ITestResult ir)
		{
			System.out.println("test started");
		}

}
