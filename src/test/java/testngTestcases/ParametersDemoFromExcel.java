package testngTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.ExcelReader;

public class ParametersDemoFromExcel {
	
	WebDriver driver;

	@Parameters({"browser","siteurl"})
	@BeforeMethod()
	public void launchBrowser(String browserName,String url) {
		
		if(browserName.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test(dataProvider = "data" )
	public void doLogin(String username,String password) {
		
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();
	}
	
	
	@DataProvider(name="data")
	public Object[][] getData() {
		ExcelReader excel = new ExcelReader("./src/test/resources/data/testData.xlsx");
		String sheetName="login";
		
		int noOfrows=excel.getRowCount(sheetName);
		int noOfCol = excel.getColumnCount(sheetName);
		//Rows are: 4 Col are: 2
		System.out.println("Rows are: " + noOfrows + "Col are: " + noOfCol);
		Object[][] data = new Object[noOfrows-1][noOfCol];
		
		for(int row=2;row<=noOfrows;row++) {//4<=4
			for(int col=0;col<noOfCol;col++) {//0<2
				data[row-2][col] = excel.getCellData(sheetName,col,row);
			}
		}
		/*
		 * data[0][0] = excel.getCellData(sheetName,0,2); data[0][1] =
		 * excel.getCellData(sheetName,1,2);
		 * 
		 * data[1][0] = excel.getCellData(sheetName,0,3); data[1][1] =
		 * excel.getCellData(sheetName,1,3);
		 * 
		 * data[2][0] = excel.getCellData(sheetName,0,4); data[2][1] =
		 * excel.getCellData(sheetName,1,4);
		 */
		
		return data;
	}
}
