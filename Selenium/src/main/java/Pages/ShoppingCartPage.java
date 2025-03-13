package Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.checkerframework.checker.index.qual.UpperBoundBottom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	WebDriver driver;
	
	@FindBy(xpath = "//div[@id='BackLink']/a")
	WebElement MainMenuLink;
	@FindBy(xpath = "//div[@id='Catalog']//h3")
	WebElement PageHeader;
	@FindBy(xpath = "//tbody//button[contains(text(),'Update Cart')]")
	WebElement UpdateCartButton;
	@FindBy(xpath = "//a[contains(text(),'Proceed to Checkout')]")
	WebElement CheckOutButton;
	@FindBy(xpath = "//table//a[text()='Remove']")
	List<WebElement> RemoveButton;
	@FindBy(xpath = "//table//a[contains(text(),'Remove All')]")
	WebElement RemoveAllButton;

	@FindBy(xpath = "//table//b[contains(text(),'Item ID')]//ancestor::tbody//td/a")
	WebElement ItemId;
	@FindBy(xpath = "//table//b[contains(text(),'Item ID')]//ancestor::tbody//td//following::td")
	WebElement ProductId;
	@FindBy(xpath = "//table//b[contains(text(),'Description')]//ancestor::tbody//td[3]")
	WebElement ProductDescription;
	@FindBy(xpath = "//table//b[contains(text(),'In Stock?')]//ancestor::tbody//td[4]")
	WebElement ProductInStock;

	@FindBy(xpath = "//table//td/strong[text()='Sub Total:']//following::td/strong")
	WebElement SubTotalPrice;
	
	double ListedPriceAmt;
	double TotalPriceAmt;
	double SubTotalPriceAmt;
	double ActualTotalPriceAmt;
	static double ActualSubTotalPriceAmt;
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ShoppingCartPage_Validation(String Header,String ItemId) {
		assertEquals(Header, PageHeader.getText());
		assertEquals(ItemId, this.ItemId.getText());
	}
	
	public void ShoppingCartRemoveProduct_Button(int index) {
		RemoveButton.get(index-1).click();
	}
	public void ValidateButtons(int total) {
		for(int i=0;i<total;i++) {
			RemoveButton.get(i).isEnabled();
		}
		//RemoveButton.isEnabled();
		RemoveAllButton.isEnabled();
		UpdateCartButton.isEnabled();
		CheckOutButton.isEnabled();
		MainMenuLink.isEnabled();
	}
	public void ShoppingCartRemoveAllProduct_Button() {
		RemoveAllButton.click();
	}
	public void ShoppingCart_UpdateCart(int Quantity,double Price,String Product) {
		WebElement QuantityField=driver.findElement(By.xpath("//td//a[contains(text(),'"+Product+"')]//parent::td//following-sibling::td//input[@type='number']"));
		if(Quantity!=1) {
			QuantityField.clear();
			QuantityField.sendKeys(String.valueOf(Quantity));
			UpdateCartButton.click();
		}
		WebElement ListedPrice=driver.findElement(By.xpath("//table//b[contains(text(),'List Price')]//ancestor::tbody//td//a[contains(text(),'"+Product+"')]//ancestor::tr//td[6]"));
		ListedPriceAmt=Double.valueOf(ListedPrice.getText().substring(1));
		assertEquals(Price, ListedPriceAmt);
		
		WebElement TotalPrice=driver.findElement(By.xpath("//table//th/b[text()='Total Cost']//ancestor::tbody//td//a[contains(text(),'"+Product+"')]//ancestor::tr//td[7]"));
		TotalPriceAmt=Double.valueOf(TotalPrice.getText().substring(1));
		ActualTotalPriceAmt=Quantity*ListedPriceAmt;
		assertEquals(TotalPriceAmt, ActualTotalPriceAmt);
		
		ActualSubTotalPriceAmt=ActualSubTotalPriceAmt+ActualTotalPriceAmt;
	}
	public void ActualSubTotalAmount_Validation() {
		SubTotalPriceAmt=Double.valueOf(SubTotalPrice.getText().substring(1));
		assertEquals(ActualSubTotalPriceAmt, SubTotalPriceAmt);
	}
	public void CheckOut_Button() {
		CheckOutButton.click();
	}
	public void MainMenu_Link() {
		MainMenuLink.click();
	}
}
