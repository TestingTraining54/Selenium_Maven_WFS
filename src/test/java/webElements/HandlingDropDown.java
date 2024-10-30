package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		WebElement langDropdown=driver.findElement(By.id("searchLanguage"));
		Select lang = new Select(langDropdown);
		lang.selectByValue("ast");
		Thread.sleep(4000);
		lang.selectByIndex(4);
		Thread.sleep(4000);
		lang.selectByVisibleText("Deutsch");
		

	}

}
