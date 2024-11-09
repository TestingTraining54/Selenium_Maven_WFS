package javascriptexecution;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HighlightElement {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		WebElement frameEle = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frameEle);
		
		WebElement ele1=driver.findElement(By.xpath("//button[text()='Try it']"));
		//ele1.click();
		WebElement ele2=driver.findElement(By.id("mySubmit"));
		//ele2.click();
		
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='4px solid green'", ele1);
		
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", ele2);
		
	}

}
