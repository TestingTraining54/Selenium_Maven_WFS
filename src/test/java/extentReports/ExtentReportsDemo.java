package extentReports;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsDemo {

	static ExtentSparkReporter htmlReports;//Generate html report/configuration
	static ExtentReports report;//Create the test /Configuration/Basic Info
	static ExtentTest test;// add/log status of testcase
	
	@BeforeTest
	public void setUp() {
		htmlReports = new ExtentSparkReporter("./src/test/resources/reports/reports.html");
		htmlReports.config().setEncoding("utf-8");
		htmlReports.config().setDocumentTitle("Learning Extent Reports");
		htmlReports.config().setReportName("Extent Report");
		htmlReports.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.attachReporter(htmlReports);
		report.setSystemInfo("Project Name", "Selenium with Extent Reports");
		report.setSystemInfo("Automation Tester", "Bhagya");
		report.setSystemInfo("Env", "QA");
	}
	
	@Test
	public void doLogin() {
		
		test=report.createTest("Login Test");
		test.info("Enter username");
		//type("","");
		test.info("Enter password");
		test.info("Click on login button");
		
	}
	
	@Test
	public void doUserReg() {
		
		test=report.createTest("User Reg Test");
		test.info("Enter first name");
		test.info("Enter last name");
		test.info("click on Register button");
		Assert.fail("Intentionally Failing User Reg Test");

	}
	
	@Test
	public void doSkip() {
		
		test=report.createTest("Skip Test");
		test.info("skip test");
		throw new SkipException("Skip the testcase");
	}
	
	@AfterMethod
	public void getStatus(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Markup m;
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			//test.pass(methodName + " is pass");
			m = MarkupHelper.createLabel(methodName + " is pass", ExtentColor.GREEN);
			test.pass(m);
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			m=MarkupHelper.createLabel(methodName + " is failed", ExtentColor.RED);
			test.fail(m);
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			m=MarkupHelper.createLabel(methodName + " is skipped", ExtentColor.AMBER);
			test.skip(m);
		}
	}
	
	@AfterTest
	public void endReport() {
		report.flush();
	}
}
		
		
		
		
		
		
		
		
		
		
