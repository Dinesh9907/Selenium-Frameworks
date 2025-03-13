package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderConfirmationPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//form//h3")
	WebElement Order_Heading;
	@FindBy(xpath = "//form//table//td//following-sibling::td")
	WebElement Order_Date_Time;
	@FindBy(xpath = "//h3//following-sibling::table//td[text()='First name:']//following-sibling::td")
	WebElement Billing_FirstName;
	@FindBy(xpath = "//h3//following-sibling::table//td[text()='Last name:']//following-sibling::td")
	WebElement Billing_LastName;
	@FindBy(xpath = "//h3//following-sibling::table//td[text()='Address 1:']//following-sibling::td")
	WebElement Billing_Address1;
	@FindBy(xpath = "//h3//following-sibling::table//td[text()='Address 2:']//following-sibling::td")
	WebElement Billing_Address2;
	@FindBy(xpath = "//h3//following-sibling::table//td[text()='City:']//following-sibling::td")
	WebElement Billing_City;
	@FindBy(xpath = "//h3//following-sibling::table//td[text()='State:']//following-sibling::td")
	WebElement Billing_State;
	@FindBy(xpath = "//h3//following-sibling::table//td[text()='Zip:']//following-sibling::td")
	WebElement Billing_Zip;
	@FindBy(xpath = "//h3//following-sibling::table//td[text()='Country:']//following-sibling::td")
	WebElement Billing_Country;
	@FindBy(xpath = "(//h3//following-sibling::table//td[text()='First name:']//following-sibling::td)[2]")
	WebElement Shipping_FirstName;
	@FindBy(xpath = "(//h3//following-sibling::table//td[text()='Last name:']//following-sibling::td)[2]")
	WebElement Shipping_LastName;
	@FindBy(xpath = "(//h3//following-sibling::table//td[text()='Address 1:']//following-sibling::td)[2]")
	WebElement Shipping_Address1;
	@FindBy(xpath = "(//h3//following-sibling::table//td[text()='Address 2:']//following-sibling::td)[2]")
	WebElement Shipping_Address2;
	@FindBy(xpath = "(//h3//following-sibling::table//td[text()='City:']//following-sibling::td)[2]")
	WebElement Shipping_City;
	@FindBy(xpath = "(//h3//following-sibling::table//td[text()='State:']//following-sibling::td)[2]")
	WebElement Shipping_State;
	@FindBy(xpath = "(//h3//following-sibling::table//td[text()='Zip:']//following-sibling::td)[2]")
	WebElement Shipping_Zip;
	@FindBy(xpath = "(//h3//following-sibling::table//td[text()='Country:']//following-sibling::td)[2]")
	WebElement Shipping_Country;
	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	WebElement Confirm_Button;
	@FindBy(xpath = "//button[contains(text(),'Back')]")
	WebElement Back_Button;
	@FindBy(xpath = "//div[@id='BackLink']/a")
	WebElement Return_Link_MainMenu;
	@FindBy(xpath = "//div[@id='MessageBar']/p")
	WebElement Message_Bar;
	
	public OrderConfirmationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void OrderConfirm_VerifyHeader(String OrderHead,String message) {
		Assert.assertEquals(Order_Heading.getText(), OrderHead);
		Assert.assertEquals(Message_Bar.getText(), message);
	}
	
	public void OrderConfirm_VerifyOrderdetails() {
		Assert.assertTrue(Order_Date_Time.isDisplayed());
	}
	
	public void OrderConfirm_VerifyBillingAddress(String FirstName,String Lastname,String Address1,String Address2,String City,String Country,String state,String zip) {
		Assert.assertEquals(Billing_FirstName.getText(), FirstName);
		Assert.assertEquals(Billing_LastName.getText(), Lastname);
		Assert.assertEquals(Billing_Address1.getText(), Address1);
		Assert.assertEquals(Billing_Address2.getText(), Address2);
		Assert.assertEquals(Billing_City.getText(), City);
		Assert.assertEquals(Billing_Country.getText(), Country);
		Assert.assertEquals(Billing_State.getText(), state);
		Assert.assertEquals(Billing_Zip.getText(), zip);
	}
	
	public void OrderConfirm_VerifyShippingAddress(String FirstName,String Lastname,String Address1,String Address2,String City,String Country,String state,String zip) {
		Assert.assertEquals(Shipping_FirstName.getText(), FirstName);
		Assert.assertEquals(Shipping_LastName.getText(), Lastname);
		Assert.assertEquals(Shipping_Address1.getText(), Address1);
		Assert.assertEquals(Shipping_Address2.getText(), Address2);
		Assert.assertEquals(Shipping_City.getText(), City);
		Assert.assertEquals(Shipping_Country.getText(), Country);
		Assert.assertEquals(Shipping_State.getText(), state);
		Assert.assertEquals(Shipping_Zip.getText(), zip);
	}
	
	public void OrderConfirm_Button() {
		Confirm_Button.click();
	}
	
	public void OrderConfirm_Back_Button() {
		Back_Button.click();
	}
}
