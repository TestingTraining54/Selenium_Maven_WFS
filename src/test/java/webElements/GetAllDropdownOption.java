package webElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GetAllDropdownOption {

	public static void main(String[] args) {
		// Get All option - drop down

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");

		WebElement langDropdown = driver.findElement(By.id("searchLanguage"));
		Select lang = new Select(langDropdown);

		List<WebElement> allLang = driver.findElements(By.tagName("option"));
		System.out.println(allLang.size());
		for(int i=0;i<allLang.size();i++) {
			System.out.println(allLang.get(i).getAttribute("lang"));
		}

	}

}
