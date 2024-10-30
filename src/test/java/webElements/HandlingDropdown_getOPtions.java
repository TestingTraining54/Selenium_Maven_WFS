package webElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdown_getOPtions {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		
		WebElement langDropdown=driver.findElement(By.id("searchLanguage"));
		Select lang = new Select(langDropdown);
		List<WebElement> allOptions = lang.getOptions();
		System.out.println(allOptions.size());//no of options
		for(WebElement a:allOptions) {
			System.out.println(a.getText());
		}
	}

}
