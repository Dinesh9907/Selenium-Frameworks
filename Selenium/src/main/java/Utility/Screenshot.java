package Utility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot extends DriversInit{
	
	public String takeScreenShot(String Path) {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File SrcScreenShot=screenshot.getScreenshotAs(OutputType.FILE);
		String Trgpath=System.getProperty("user.dir")+Path+".png";
		File TrgScreenShot=new File(Trgpath);
		SrcScreenShot.renameTo(TrgScreenShot);
		return Trgpath;
	}
}
