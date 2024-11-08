package webElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class RadioButtons3 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://designsystem.digital.gov/components/radio-buttons/");
		
		
		//driver.findElement(By.linkText("Create new account")).click();
		List<WebElement> gender=driver.findElements(By.xpath("//div[@class='usa-radio']/input[@name='historical-figures']"));
		gender.get(1).click();
		
		
	}

}
