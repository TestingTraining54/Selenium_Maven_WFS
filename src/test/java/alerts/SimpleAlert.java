package alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleAlert {
/*
 * Simple alert - Text + OK
 * Prompt alert - Text-txtfield get data from user - OK
 * Confirmation alert - Text - OK and Cancel
 * 
 * 
 */
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.automationtesting.in/Alerts.html");
		//driver.findElement(By.linkText("Alert with OK ")).click();
		driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
	
	
	}

}
