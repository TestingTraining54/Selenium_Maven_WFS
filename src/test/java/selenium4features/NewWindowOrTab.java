package selenium4features;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowOrTab {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://google.com");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://redbus.com");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://gmail.com");
	}

}
