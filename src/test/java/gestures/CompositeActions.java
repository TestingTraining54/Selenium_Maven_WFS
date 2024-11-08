package gestures;


import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CompositeActions {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		
		WebElement username=driver.findElement(By.id("email"));
		Actions act = new Actions(driver);
		act.click(username)
		.keyDown(Keys.SHIFT)
		.sendKeys(username,"bhagya")//BHAGYA
		.keyUp(Keys.SHIFT)
		.doubleClick(username)
		.contextClick(username)
		.build()
		.perform();

	}

}
