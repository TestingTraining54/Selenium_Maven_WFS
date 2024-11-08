package webElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RadioButtons2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://materializecss.com/radio-buttons.html");
		
		
		//driver.findElement(By.linkText("Create new account")).click();
		List<WebElement> gender=driver.findElements(By.xpath("//input[@type='radio']"));
		Actions act= new Actions(driver);
		act.moveToElement(gender.get(2)).click().build().perform();
		
	}

}
