package com.nopCommerceapplication.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.nopCommerceapplication.testcases.Baseclass;

public class Listener extends Baseclass implements ITestListener{
	
	ExtentReports extentreports;
	ExtentTest exe;
	Extentreport extent;
	
	@Override
	public void onStart(ITestContext context) {
		
		extent = new Extentreport();
	    extentreports = extent.generateExtentReport();
		System.out.println("project test got started");
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
		String testName = result.getName();
		 exe = extentreports.createTest(testName);
		 
		exe.log(Status.INFO, testName+ " started successfully" ); // This code will make print on the report 
		
		System.out.println(testName+ " Testcase started successfully"); // This code will make print on the console 
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getName();
		
		exe.log(Status.PASS, testName+ " Testcase passed successfully"); // This code will make print on the report 
		
		System.out.println(testName+ " Testcase passed successfully"); // This code will make print on the console 
		
	}
	
	@Override
	public void onTestFailure( ITestResult result) {
		
		String testName = result.getName();
					       
			exe.addScreenCaptureFromPath(takeScreenshot(testName,driver),testName);
	        
			exe.log(Status.INFO,result.getThrowable());
	        
	        exe.log(Status.FAIL,testName+ " Testcase got failed");
	        
	        System.out.println(testName+ " Testcase got falied");	
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
		String testName = result.getName();

		exe.log(Status.INFO,result.getThrowable());
		
		exe.log(Status.SKIP, testName+ " Testcase got skipped");	
		
		 System.out.println(testName+ " Testcase got skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentreports.flush();
			
	}

}
