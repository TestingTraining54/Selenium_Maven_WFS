package windows;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindows {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.facebook.com/");
	
	String parentWindow=driver.getWindowHandle();//single window id
	System.out.println("Parent window id: " + parentWindow);
	
	driver.findElement(By.linkText("Meta Pay")).click();
	Set<String> allWindow = driver.getWindowHandles();
	
	for(String a:allWindow) {
		System.out.println(a);//52FF974F1D811EC039C82BDA1AFB9DDC
		
		if(!(a.equals(parentWindow))) {
			driver.switchTo().window(a);
			driver.findElement(By.linkText("Shop Meta")).click();
		}
	}
	
}
}
