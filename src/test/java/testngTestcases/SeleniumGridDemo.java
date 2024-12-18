package testngTestcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumGridDemo {

	public WebDriver driver;
	public Capabilities cap;
	
	@Parameters({"siteurl","browser"})
	@Test
	public void openBrowser(String url,String browser) throws MalformedURLException {
		if(browser.equals("chrome")) {
			cap = new ChromeOptions();
		}
		else if(browser.equals("firefox")) {
			cap = new FirefoxOptions();
		}
		
		else if(browser.equals("edge")) {
			cap = new EdgeOptions();
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/"), cap);
		driver.get(url);
		driver.manage().window().maximize();
		
	}
}
