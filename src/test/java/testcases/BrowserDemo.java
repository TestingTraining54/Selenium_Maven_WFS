package testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDemo {

	public static void main(String[] args) {
		String browserName = "edge";
		
		//int a;
		WebDriver driver = null;
		if (browserName.equalsIgnoreCase("CHROME")) {
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		/* TestNG,Apache POI,Java Mail....
		 * Options opt = driver.manage(); Window win = opt.window(); win.maximize();
		 */
		
		//Method Chaining
		driver.manage().window().maximize();
		
		driver.get("https://google.com");
		String expectedURL="https://www.google.com/";
		String actualURL = driver.getCurrentUrl();
		
		if(actualURL.equals(expectedURL)) {
			System.out.println("Url is loaded correctly");
		}
		else {
			System.out.println("Please check url is not loaded properly");
		}
		String expectedTitle="Google";
		String actualTitle=driver.getTitle();
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Title is displayed correctly");
		}
		else {
			System.out.println("Please verify the title as it is incorrect");
		}
		
		driver.close();

	}

}
