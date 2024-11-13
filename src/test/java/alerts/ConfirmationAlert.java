package alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfirmationAlert {
/*
 * Simple alert - Text + OK
 * Prompt alert - Text-txtfield get data from user - OK
 * Confirmation alert - Text - OK and Cancel
 * 
 * 
 */
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.findElement(By.xpath("//a[@href=\"#CancelTab\"]")).click();
		driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();
		Alert al1 = driver.switchTo().alert();
		System.out.println(al1.getText());
		al1.dismiss();//cancel
		WebElement dismissText=driver.findElement(By.id("demo"));
		if(dismissText.getText().equals("You Pressed Cancel")) {
			System.out.println("Successfully cancelled the alert");
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.findElement(By.xpa("Alert with OK & Cancel ")).click();
		driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();
		Alert al2 = driver.switchTo().alert();
		System.out.println(al2.getText());
		al2.accept();//OK
		WebElement acceptText=driver.findElement(By.id("demo"));
		if(acceptText.getText().equals("You pressed Ok")) {
			System.out.println("Successfully accepted the alert");
		}
	
	}

}
