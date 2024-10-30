package webElements;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCheckboxes {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.ironspider.ca/forms/checkradio.htm");
		
		List<WebElement> allCheckboxes = driver.findElements(By.name("color"));
		
		/*
		 * allCheckboxes.get(2).click(); allCheckboxes.get(4).click();
		 */
		for(int i=0;i<allCheckboxes.size();i++) {
			//allCheckboxes.get(i).click();
			
			WebElement ele = allCheckboxes.get(i);//ele = 2st
			String attrValue = ele.getAttribute("value");//Blue
			
			//if(allCheckboxes.get(i).getAttribute("value").equals
			if(attrValue.equals("blue") || attrValue.equals("green")) {
				ele.click();
			}
			
			

		}
		

	}

}
