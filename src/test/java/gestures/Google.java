package gestures;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Google {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com/");
		WebElement search = driver.findElement(By.name("q"));
		Actions act = new Actions(driver);
		act.sendKeys(search, "Selenium")
		.sendKeys(Keys.ARROW_DOWN)
		.pause(Duration.ofSeconds(2))
		.sendKeys(Keys.ARROW_DOWN)
		.pause(Duration.ofSeconds(2))
		.sendKeys(Keys.ARROW_DOWN)
		.pause(Duration.ofSeconds(2))
		.sendKeys(Keys.ARROW_DOWN)
		.pause(Duration.ofSeconds(2))
		.sendKeys(Keys.ENTER)
		.build()
		.perform();
		

	}

}
