package selenium4features;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class DevToolsDemo {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		DevTools dev = driver.getDevTools();
		Map<String,Object> deviceMetrics=new HashMap<String, Object>();
		deviceMetrics.put("width", 600);
		deviceMetrics.put("height", 1000);
		deviceMetrics.put("deviceScaleFactor", 50);
		deviceMetrics.put("mobile", true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		
		
		driver.get("https://google.com");
		
		

	}

}
