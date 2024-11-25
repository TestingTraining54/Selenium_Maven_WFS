package testngTestcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testcase1 {
	/*
	 * Help>Eclipse MarketPlace > Search TestNG > Install Add TestNG maven
	 * dependency to pom.xml 
	 * BeforeClass
	 * BeforeMethod 
	 * Testcase1 
	 * AfterMethod 
	 * BeforeMethod
	 * Testcase2 
	 * AfterMethod
	 * AfterClass
	 */

	@BeforeClass
	public void startDB() {
		System.out.println("DB started");
	}

	@AfterClass
	public void CloseDB() {
		System.out.println("DB closed");
	}

	@BeforeMethod
	public void setUp() {
		System.out.println("Open Browser");
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("Close Browser");
	}

	@Test(dependsOnMethods = {"doUserReg"})
	public void doLogin() {
		System.out.println("Do login");
	}

	@Test
	public void doUserReg() {
		System.out.println("Do user Registration");
		Assert.fail("user registration failed");
	}

	
}
