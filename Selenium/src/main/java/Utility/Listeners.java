package Utility;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners implements ITestListener{
	  
	 public ExtentSparkReporter sparkReporter;//UI
	 public ExtentReports extentreports;//Common Info
	 public ExtentTest tests;//Test Result
	
	 public void onStart(ITestContext context) {
		 sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/testReport.html");
		 sparkReporter.config().setDocumentTitle("Automation Test Report");
		 sparkReporter.config().setReportName("Regression Test");
		 sparkReporter.config().setTheme(Theme.DARK);
		 
		 extentreports=new ExtentReports();
		 extentreports.attachReporter(sparkReporter);
		 extentreports.setSystemInfo("Environment", "QA");
		 extentreports.setSystemInfo("Tester", System.getProperty("user.name"));
		 String OS=context.getCurrentXmlTest().getParameter("os");
		 extentreports.setSystemInfo("Operating System", OS);
		 String Browser=context.getCurrentXmlTest().getParameter("browser");
		 extentreports.setSystemInfo("Browser", Browser);
		 
	  }
	 public void onTestStart(ITestResult result) {
		 
	    
	 }
	 public void onTestSuccess(ITestResult result) {
	     tests=extentreports.createTest(result.getName());//entry in report
	     tests.log(Status.PASS, result.getName()+" Passed Successfully..");//status in entry
	 }

	 public void onTestFailure(ITestResult result) {
		 tests=extentreports.createTest(result.getName());
		 tests.log(Status.FAIL, result.getName()+" got failed..");
		 tests.log(Status.INFO, result.getThrowable().getMessage());
		 try {
			 String FailedScreenshot=new Screenshot().takeScreenShot(result.getName());
			 tests.addScreenCaptureFromPath(FailedScreenshot);
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	 }

	 public void onTestSkipped(ITestResult result) {
		  tests=extentreports.createTest(result.getName());
		  tests.log(Status.SKIP, result.getName()+" got skipped...");
		  tests.log(Status.INFO, result.getThrowable().getMessage());
	 }

	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	   
	 }

	 public void onTestFailedWithTimeout(ITestResult result) {
		 
	 }

	 public void onFinish(ITestContext context) {
	  extentreports.flush();  
	 }
}
