package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import stepDefintion.SharedSteps;

public class MyListeners implements ITestListener {

	ScreenshotUtilities screenshotUtil;
	ExtentReports extentReports;
	ExtentTest 	extentTest; 
	SharedSteps sharedSteps; 
	

	
	

	public void onTestFailure(ITestResult result) {
	    try {
	    	extentTest.addScreenCaptureFromPath(screenshotUtil.takeScreenshot());
	    	System.out.println("Taking screenshot");
	    	extentTest.fail(result.getThrowable());
	    	extentTest.log(Status.FAIL, "This is a fail message");

	    	
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	  }
	
	
	public void onStart(ITestContext context) {
			 screenshotUtil=new ScreenshotUtilities();
			 
			 System.out.println("TestNG Started");
			 ExtentSparkReporter sparkreporter = new ExtentSparkReporter("Automation-Test-Report.html");
			 extentReports = new ExtentReports();
			 extentReports.attachReporter(sparkreporter);			
			 extentTest=extentReports.createTest(context.getName());
			
				
		  }
	
	 
	  public  void onTestSuccess(ITestResult result) {
		  extentTest.log(Status.PASS, " Test Scenario is successfully pass");
	  }
	  
	public void onFinish(ITestContext context) {
		extentReports.flush();
		try {
			Desktop.getDesktop().browse(new File("Automation-Test-Report.html").toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
