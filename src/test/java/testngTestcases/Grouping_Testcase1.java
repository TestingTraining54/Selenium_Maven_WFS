package testngTestcases;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Grouping_Testcase1 {

	@Test(groups = {"smoke"})
	public void vehicle1() {
		System.out.println("vehicle1");
		Reporter.log("vehicle 1 is executed");
		
	
	}
	
	@Test(groups = {"smoke","sanity"})
	public void vehicle2() {
		System.out.println("vehicle2");
		Reporter.log("vehicle 2 is executed");
	}
	
	@Test(groups = {"Regression"})
	public void vehicle3() {
		System.out.println("vehicle3");
		Reporter.log("vehicle 3 is executed");
	}
}
