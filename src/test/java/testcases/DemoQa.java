package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQa {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		driver.get("https://demoqa.com/automation-practice-form");
		
		//WebElement element = driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div/div[2]/div/input"));
		WebElement subject = driver.findElement(By.id("subjectsInput"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		//wait.until(ExpectedConditions.elementToBeClickable(element));
		
		subject.sendKeys("This is a test");
		List<WebElement> allCheckboxes = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']/div[2]/div/input"));
		wait.until(ExpectedConditions.elementToBeClickable(allCheckboxes.get(1)));
		allCheckboxes.get(1).click();

	}

}
