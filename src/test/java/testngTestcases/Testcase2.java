package testngTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testcase2 {

	//Assertions
	
	//@Test
	public void verifyTitle() {
		String expectedTitle = "gmail.com";
		String actualTitle = "gmail.com";
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Pass");
		}
		
		else {
			System.out.println("Failure");
		}
		
		//Assert.assertEquals(actualTitle,expectedTitle);//Pass - Fail - Hard Assert 
		Assert.assertTrue(actualTitle.equals(expectedTitle), "Your titles are not matching");
		//Assert.assertFalse(actualTitle.equals(expectedTitle), "Your titles are matching");
		
		System.out.println("End of Testcase");
	}
	
	@Test
	public void softAssertDemo() {
		String expectedTitle = "Gmail.com";
		String actualTitle = "gmail.com";
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualTitle, expectedTitle);
		sa.assertTrue(false);
		sa.assertFalse(true);
		
		
		
		System.out.println("End of Testcase 1");
		System.out.println("End of Testcase 2");
		System.out.println("End of Testcase 3");
		
		sa.assertAll();
	}
	
}
