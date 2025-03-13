package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PaymentPage {

	WebDriver driver;
	
	@FindBy(xpath="//form//h3")
	WebElement Payment_Heading;
	
	@FindBy(xpath = "//form//tr//td[text()='Card Type:']//following-sibling::td//select")
	WebElement Card_Types;
	@FindBy(xpath = "//form//tr//td[text()='Card Number:']//following-sibling::td//input")
	WebElement Card_Number;
	@FindBy(xpath = "//form//tr//td[text()='Expiry Date (MM/YYYY):']//following-sibling::td//input")
	WebElement Expiry_Date_MMYYYY;
	@FindBy(xpath = "//form//h3[text()='Billing Address']")
	WebElement BillingAddress_Heading;
	@FindBy(xpath = "//form//td[text()='First name:']//following-sibling::td//input")
	WebElement BillingAddress_FirstName;
	@FindBy(xpath = "//form//td[text()='Last name:']//following-sibling::td//input")
	WebElement BillingAddress_LastName;
	@FindBy(xpath = "//form//td[text()='Address 1:']//following-sibling::td//input")
	WebElement BillingAddress_Address1;
	@FindBy(xpath = "//form//td[text()='Address 2:']//following-sibling::td//input")
	WebElement BillingAddress_Address2;
	@FindBy(xpath = "//form//td[text()='City:']//following-sibling::td//input")
	WebElement BillingAddress_City;
	@FindBy(xpath = "//form//td[text()='State:']//following-sibling::td//input")
	WebElement BillingAddress_State;
	@FindBy(xpath = "//form//td[text()='Zip:']//following-sibling::td//input")
	WebElement BillingAddress_Zip;
	@FindBy(xpath = "//form//td[text()='Country:']//following-sibling::td//input")
	WebElement BillingAddress_Country;
	@FindBy(xpath = "//form//td//input[@name='shippingAddressRequired']")
	WebElement ShippingAddress_Check;
	@FindBy(xpath = "//form//div//button[text()='Continue']")
	WebElement PaymentPage_Continue_Button;
	@FindBy(xpath = "//form//div//button[text()='Cancel']")
	WebElement PaymentPage_Cancel_Button;
	@FindBy(xpath = "//form//h3")
	WebElement ShippingAddress_Heading;
	@FindBy(xpath = "//form//td[text()='First name:']//following-sibling::td//input")
	WebElement ShippingAddress_firstname;
	@FindBy(xpath = "//form//td[text()='Last name:']//following-sibling::td//input")
	WebElement ShippingAddress_lastname;
	@FindBy(xpath = "//form//td[text()='Address 1:']//following-sibling::td//input")
	WebElement ShippingAddress_Address1;
	@FindBy(xpath = "//form//td[text()='Address 2:']//following-sibling::td//input")
	WebElement ShippingAddress_Address2;
	@FindBy(xpath = "//form//td[text()='City:']//following-sibling::td//input")
	WebElement ShippingAddress_City;
	@FindBy(xpath = "//form//td[text()='State:']//following-sibling::td//input")
	WebElement ShippingAddress_State;
	@FindBy(xpath = "//form//td[text()='Zip:']//following-sibling::td//input")
	WebElement ShippingAddress_Zip;
	@FindBy(xpath = "//form//td[text()='Country:']//following-sibling::td//input")
	WebElement ShippingAddress_Country;
	@FindBy(xpath = "//form//div//button[text()='Continue']")
	WebElement ShippingAddress_Continue_Button;
	@FindBy(xpath = "//form//div//button[text()='Back']")
	WebElement ShippingAddress_Back_Button;
	
	public PaymentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void PaymentDetails(String PaymentHeader,String CardType,String cardNumber,String ExpiryDate) {
		Assert.assertEquals(Payment_Heading.getText(), PaymentHeader);
		Select cardType_dropdown=new Select(Card_Types);
		cardType_dropdown.selectByVisibleText(CardType);
		Card_Number.clear();
		Card_Number.sendKeys(cardNumber);
		Expiry_Date_MMYYYY.clear();
		Expiry_Date_MMYYYY.sendKeys(ExpiryDate);
	}
	
	public void BillingDetails(String BillingHeader,String FirstName,String LastName,String Address1,String Address2,String City,String State,String country,String zip) {
		Assert.assertEquals(BillingAddress_Heading.getText(), BillingHeader);
		BillingAddress_FirstName.clear();
		BillingAddress_FirstName.sendKeys(FirstName);
		BillingAddress_LastName.clear();
		BillingAddress_LastName.sendKeys(LastName);
		BillingAddress_Address1.clear();
		BillingAddress_Address1.sendKeys(Address1);
		BillingAddress_Address2.clear();
		BillingAddress_Address2.sendKeys(Address2);
		BillingAddress_City.clear();
		BillingAddress_City.sendKeys(City);
		BillingAddress_State.clear();
		BillingAddress_State.sendKeys(State);
		BillingAddress_Country.clear();
		BillingAddress_Country.sendKeys(country);
		BillingAddress_Zip.clear();
		BillingAddress_Zip.sendKeys(zip);
	}
	
	public void Shipping_CheckBox() {
		ShippingAddress_Check.click();
	}
	
	public void ShippingDetails(String ShippingHeader,String FirstName,String LastName,String Address1,String Address2,String City,String State,String Country,String Zip) {
		Assert.assertEquals(ShippingAddress_Heading.getText(), ShippingHeader);
		ShippingAddress_firstname.sendKeys(FirstName);
		ShippingAddress_lastname.sendKeys(LastName);
		ShippingAddress_Address1.sendKeys(Address1);
		ShippingAddress_Address2.sendKeys(Address2);
		ShippingAddress_City.sendKeys(City);
		ShippingAddress_State.sendKeys(State);
		ShippingAddress_Country.sendKeys(Country);
		ShippingAddress_Zip.sendKeys(Zip);
	}
	
	public void ShippingPage_Continue() {
		ShippingAddress_Continue_Button.click();
	}
	
	public void ShippingPage_Back() {
		ShippingAddress_Back_Button.click();
	}
	
	public void PaymentPage_Continue() {
		PaymentPage_Continue_Button.click();
	}
	
	public void PaymentPage_Cancel() {
		PaymentPage_Cancel_Button.click();
	}
}
