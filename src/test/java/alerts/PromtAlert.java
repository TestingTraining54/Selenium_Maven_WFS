package alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PromtAlert {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.findElement(By.xpath("//a[@href=\"#Textbox\"]")).click();
		
		driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		String textTobeEntered = "Selenium with Java";
		al.sendKeys(textTobeEntered);
		al.accept();
		WebElement promtText=driver.findElement(By.id("demo1"));
		if(promtText.getText().equals("Hello "+textTobeEntered +" How are you today")) {
			System.out.println("Successfully entered text to the alert: " + textTobeEntered);
		}
		
	}

}
