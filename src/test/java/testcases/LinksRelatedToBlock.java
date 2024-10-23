package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksRelatedToBlock {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		
		WebElement block = driver.findElement(By.className("other-projects"));
		
		List<WebElement> blockRelatedLinks=block.findElements(By.tagName("a"));
		System.out.println(blockRelatedLinks.size());//no of links present in that block

		for(int i=0;i<blockRelatedLinks.size();i++) {
			System.out.println(blockRelatedLinks.get(i).getText());
		}
		
	}

}
