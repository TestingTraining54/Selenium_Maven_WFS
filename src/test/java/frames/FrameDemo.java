package frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		//driver.switchTo().frame("iframeResult");//id or name
		//driver.switchTo().frame(1);//index
		WebElement frameEle = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frameEle);
		//id or name
		//index
		//WebElement
		WebElement ele=driver.findElement(By.xpath("//button[text()='Try it']"));
		ele.click();
		
		driver.switchTo().defaultContent();//switch out of the frame
		driver.findElement(By.id("menuButton")).click();
		
	}

}
