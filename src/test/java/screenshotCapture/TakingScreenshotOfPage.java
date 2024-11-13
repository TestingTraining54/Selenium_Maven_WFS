package screenshotCapture;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TakingScreenshotOfPage {
	static WebDriver driver;

	public static void getPageScreenshot() throws IOException {

		Date d = new Date();
		String fileName = d.toString().replace(" ", "_").replace(":", "_") + ".png";

		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshot/" + fileName);
		FileUtils.copyFile(screenshot, destination);
	}

	public static void getElementScreenshot(WebElement ele) throws IOException {

		Date d = new Date();
		String fileName = "ele_"+d.toString().replace(" ", "_").replace(":", "_") + ".png";

		File screenshot = ele.getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshot/" + fileName);
		FileUtils.copyFile(screenshot, destination);
	}
	
	public static void getFullPageScreenshot() throws IOException {

		Date d = new Date();
		String fileName = "Full Page_"+d.toString().replace(" ", "_").replace(":", "_") + ".png";

		File screenshot = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshot/" + fileName);
		FileUtils.copyFile(screenshot, destination);
	}
	

	public static void main(String[] args) throws IOException {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://facebook.com");

		getPageScreenshot();
		
		WebElement username = driver.findElement(By.id("email"));
		getElementScreenshot(username);

		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		getPageScreenshot();
		
		getFullPageScreenshot();

		
		
	}

}
