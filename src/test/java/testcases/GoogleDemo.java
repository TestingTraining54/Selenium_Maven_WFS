package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		WebElement searchbox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
		searchbox.sendKeys("selenium webdriver");
		
		WebElement storeEle = driver.findElement(By.linkText("Store"));
		storeEle.click();
		
		String actualURL = driver.getCurrentUrl();
		if(actualURL.contains("store.google.com")) {
			System.out.println("Pass - Navigated succefully to store page");
		}
	
	}

}
