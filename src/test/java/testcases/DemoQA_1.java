package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//ctrl+shift+o

public class DemoQA_1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		driver.get("https://demoqa.com/checkbox");
		WebElement parent=driver.findElement(By.xpath("//span[@class='rct-text']/button[@title='Toggle'][@class='rct-collapse rct-collapse-btn']"));
		parent.click();
		 
		
		List<WebElement>
		  otherEle=wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(
		  "//button[@title='Toggle']"), 4)); otherEle.get(2).click();
		 
		

	}

}
