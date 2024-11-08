package gestures;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseAction_DragAndDropBy2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");

		WebElement draggable = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		Actions act = new Actions(driver);
		WebElement slider=driver.findElement(By.id("slider"));
		Dimension d = slider.getSize();
		int width=d.getWidth();
		
		act.dragAndDropBy(draggable,width/2,0)
		.dragAndDropBy(slider, -width/4, 0).build().perform();
		
	}

}
