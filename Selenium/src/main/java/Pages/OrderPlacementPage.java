package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderPlacementPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[@id='Catalog']//h3")
	WebElement PageHeading;
	
	@FindBy(xpath = "//table//td[contains(text(),'stock')]")
	WebElement ProductStock;
	@FindBy(xpath = "//table//td[contains(text(),'$')]")
	WebElement ProductPrice;
	@FindBy(xpath = "//a[@class='button' and contains(text(),'Add to Cart')]")
	WebElement SubProductAddToCartButton;
	
	
	public OrderPlacementPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void Catagory_Link(String Catagory) {
		WebElement CatagoryLink=driver.findElement(By.xpath("//a[contains(text(),'"+Catagory+"')]"));
		CatagoryLink.click();
	}
	public void CatagoryPage_Validation(String Catagory) {
		Assert.assertEquals(Catagory, PageHeading.getText());
	}
	public void Product_Link(String Product) {
		
		WebElement ProductLink=driver.findElement(By.xpath("//td[contains(text(),'"+Product+"')]/parent::tr//a"));
		ProductLink.click();
	}
	public void SubProduct_Link(String SubProduct) {
		WebElement SubProductLink=driver.findElement(By.xpath("//td[contains(text(),'"+SubProduct+"')]/preceding-sibling::td/a"));
		SubProductLink.click();
	}
	public void SubProduct_Page_Validation(String SubProduct) {
		WebElement SubProductDesc=driver.findElement(By.xpath("//small[contains(text(),'')]"));
		Assert.assertTrue(SubProductDesc.getText().contains(SubProduct));
	}
	public void SubProduct_AddToCart_Button() {
		SubProductAddToCartButton.click();
	}
	

}
