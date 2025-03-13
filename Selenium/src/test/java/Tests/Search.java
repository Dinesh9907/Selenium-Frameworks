package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.Screenshot;

public class Search {
	@Test
	public void test() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jpetstore.aspectran.com/");
		driver.findElement(By.xpath("//div//input[@placeholder='Product Search']")).sendKeys("fish");
		driver.findElement(By.xpath("//div//div[@class='input-group-button']//button[text()]")).click();
		
		String SearchText=driver.findElement(By.xpath("//div//h3")).getText();
		Assert.assertEquals("Search Results for \"fish\"", SearchText);
		Screenshot ss=new Screenshot();
		ss.takeScreenShot("\\screenshot\\file1");
		Thread.sleep(1000);
		driver.close();
	}
	
}
