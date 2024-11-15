package webElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingTables {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");

		WebElement ele = driver.findElement(By.xpath("//table/tbody/tr[2]/td[5]"));
		System.out.println(ele.getText());

		if (ele.getText().equals("12000")) {
			System.out.println("Pass");
		} else {
			System.out.println("fail");
		}

	}

}
