package testngListener;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		Reporter.log("Testcase has been started: " +result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
	    Reporter.log("Testcase has been passed: " +result.getName());
	  }
	
	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Screenshot link as the testcase has been failed: " + result.getName());
		Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\91733\\OneDrive\\Desktop\\nw.jpg\">screenshotlink</a>");
		Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\91733\\OneDrive\\Desktop\\nw.jpg\"><img src=\"C:\\Users\\91733\\OneDrive\\Desktop\\nw.jpg\" width=200 height=200/></a>");
	  }
	
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Testcase has been skipped: " +result.getName());
	}
}
