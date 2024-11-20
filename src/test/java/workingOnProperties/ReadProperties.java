package workingOnProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
		try {
		driver.findElement(By.id(or.getProperty("email_ID"))).sendKeys("testing@gmail.com");
		log.info("Typed on email field");
		driver.findElement(By.id(or.getProperty("pass_ID"))).sendKeys("password123");
		log.info("Typed on password field");
		driver.findElement(By.xpath(or.getProperty("loginBtn_XPATH"))).click();
		log.info("Clicked on Login button");
		}
		catch (Exception e) {
			log.error(e.getMessage());
		}
		
	}

}
