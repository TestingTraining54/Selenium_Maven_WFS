package webElements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAllLinks {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("No. of links are: " + allLinks.size());
		
		for(WebElement a:allLinks) {
			System.out.println(a.getText());
		}

	}

}
