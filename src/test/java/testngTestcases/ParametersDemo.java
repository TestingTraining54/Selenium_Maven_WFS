package testngTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersDemo {
	
	WebDriver driver;

	@Parameters({"browser","siteurl"})
	@BeforeMethod()
	public void launchBrowser(String browserName,String url) {
		
		if(browserName.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	
	@Test(dataProvider = "data" )
	public void doLogin(String username,String password) {
		
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();
	}
	
	
	@DataProvider(name="data")
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "username1";
		data[0][1] = "password1";
		
		data[1][0] = "username2";
		data[1][1] = "password2";
		
		data[2][0] = "username3";
		data[2][1] = "password3";
		
		return data;
	}
}
