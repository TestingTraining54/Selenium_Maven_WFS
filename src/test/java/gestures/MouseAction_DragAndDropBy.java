package gestures;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseAction_DragAndDropBy {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/resources/demos/resizable/default.html");

		WebElement draggable = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(draggable, 100,100).perform();
	}

}
