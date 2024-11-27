package testngTestcases;

import org.testng.annotations.Test;

public class Grouping_Testcase2 {

	@Test(groups = {"sanity"})
	public void vehicle4() {
		System.out.println("vehicle4");
	}
	
	@Test(groups = {"regression"})
	public void vehicle5() {
		System.out.println("vehicle5");
	}
}
