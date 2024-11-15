package webElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingTables2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");

		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		int noOfRows = rows.size();
		System.out.println("No of rows are: " + noOfRows);
		
		List<WebElement> cols = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
		int noOfCol = cols.size();
		System.out.println("No of cols are: " + noOfCol);
		
		for(int i=0;i<noOfRows;i++) {//row=5 - i=0
			
			for(int j=0;j<noOfCol;j++) {//col = 7 - j=1
			WebElement colEle=driver.findElement(By.xpath("//table/tbody/tr["+(i+1)+"]/td["+(j+1)+"]"));
			String text= colEle.getText();
			System.out.println(text);
				
			
			}
		}
		
		//System.out.println(rows.get(0).getText());//first row
		

	}

}
