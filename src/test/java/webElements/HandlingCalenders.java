package webElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingCalenders {

	public static void main(String[] args) {

////div[@class='DayPicker-Months']/div[1]/div[3]/div[4]/div/div/p[1]

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement departure = driver.findElement(By.xpath("//div[@class='flt_fsw_inputBox dates inactiveWidget ']/label/span[@class='lbl_input appendBottom10']"));
		wait.until(ExpectedConditions.elementToBeClickable(departure));
		departure.click();
		driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[1]/div[3]/div[4]/div[6]/div/p[1]")).click();
	
		WebElement dateVerify = driver.findElement(By.xpath("//p[@data-cy='departureDate']/span[1]"));
		if(dateVerify.getText().equals("22")) {
			System.out.println("Successfully selected the prefered date");
		}
		else {
			System.out.println("Failure");
		}
		
		//https://www.air.irctc.co.in/
	}

}
