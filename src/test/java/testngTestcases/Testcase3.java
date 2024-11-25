package testngTestcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class Testcase3 {

	
	@Test
	public void userReg() {
		Assert.fail("Intentionally fails a testcase");
	}
	
	@Test
	public void doSkip() {
		throw new SkipException("Skip the testcase intentionally");
	}
}
