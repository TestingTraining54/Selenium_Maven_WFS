package workingOnProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadProperties {
public static WebDriver driver;
static FileInputStream fis;
static Properties config;
static Properties or;
static Logger log=Logger.getLogger(ReadProperties.class);

public static WebElement getWebElement(String keyword) {
	WebElement ele = null;
	if(keyword.endsWith("_ID")) {
		ele=driver.findElement(By.id(or.getProperty(keyword)));
	}
	else if(keyword.endsWith("_NAME")) {
		driver.findElement(By.name(or.getProperty(keyword)));
	}
	else if(keyword.endsWith("_CSS")) {
		driver.findElement(By.cssSelector(or.getProperty(keyword)));
	}
	else if(keyword.endsWith("_XPATH")) {
		driver.findElement(By.xpath(or.getProperty(keyword)));
	}
	else if(keyword.endsWith("_CLASS")) {
		driver.findElement(By.className(or.getProperty(keyword)));
	}
	return ele;
}


//type/click/select
public static void type(String keyword,String value) {
	try {
	getWebElement(keyword).sendKeys(value);
	}
	catch (Exception e) {
		log.error("Element is not found - unable to type on element with keyword: " + keyword);
		log.error(e.getMessage());
	}
	//ExtentTest.test.info("")
	log.info("Typed on field with a keyword as : " + keyword + " with  a value as : " + value);
}

public static void click(String keyword) {
	try {
		getWebElement(keyword).click();
	}
	catch(Exception e) {
		log.error("Unable to click on element with keyword: " + keyword);
		log.error(e.getMessage());
	}
	log.info("Clicked on field with a keyword as : " + keyword);
}
	public static void main(String[] args) throws IOException {
		fis=new FileInputStream("./src/test/resources/properties/log4j.properties");
		PropertyConfigurator.configure(fis);
		
		fis = new FileInputStream("./src/test/resources/properties/config.properties");
		config = new Properties();
		config.load(fis);
		log.info("Config properties file has been loaded");
		
		fis = new FileInputStream("./src/test/resources/properties/or.properties");
		or = new Properties();
		or.load(fis);
		log.info("OR properties file has been loaded");
		
		if(config.getProperty("browser").equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
			log.info("Chrome browser has been launched");
		}
		else if(config.getProperty("browser").equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
			log.info("Firefox browser has been launched");
		}
		else if(config.getProperty("browser").equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
			log.info("Edge browser has been launched");
		}
		
		driver.manage().window().maximize();
		log.info("Browser has been maximized");
		driver.manage().timeouts().
		implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));
		driver.get(config.getProperty("testsiteurl"));
		log.info("Opened url: " + config.getProperty("testsiteurl"));
		
		type("email_ID","testing@gmail.com");
		type("pass_ID","password123");
		click("loginBtn_XPATH");
		
		
	}

}
