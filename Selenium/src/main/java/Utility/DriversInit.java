package Utility;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriversInit {
	String browser="Chrome";
	public static WebDriver driver;
	ReadProp readString=new ReadProp();
	String url;
		
	
	@BeforeSuite
	public void driverSelection() throws IOException {
		url=readString.propReader("url");
		
		if(browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions options=new ChromeOptions();
			Map<String,Object> prefs=new HashMap<String,Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.default_content_setting_values.notifications", 2);
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-popup-blocking");
			driver=new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")){
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@AfterSuite
	public void driverClose() {
		driver.quit();
	}
}
