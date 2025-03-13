package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderDetails {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='MenuContent']//a[text()='My Orders']")
	WebElement MyOrders_Page_Link;
	@FindBy(xpath="//div[@id='Content']//div//h3")
	WebElement MyOrders_Page_Header;
	@FindBy(xpath="//table//tr//th[text()='Order ID']//parent::tr//following-sibling::tr//a")
	List<WebElement> MyOrders_Orders;
	
	@FindBy(xpath="//div//h3[text()='Order']")
	WebElement OrderDetail_Header;
	@FindBy(xpath="//div[@id='MessageBar']/p")
	WebElement Order_Message_Bar;
	@FindBy(xpath = "//div[@id='BackLink']/a")
	WebElement Return_Link_MainMenu;
	@FindBy(xpath="//div//td[text()='Order No.']//following-sibling::td")
	WebElement OrderDetail_OrderNo;
	@FindBy(xpath="//div//td[text()='Order Date']//following-sibling::td")
	WebElement OrderDetail_OrderDate;
	@FindBy(xpath="//div//h3[text()='Payment Details']")
	WebElement OrderDetail_PaymentDetails;
	@FindBy(xpath="//div//td[text()='Card Type:']//following-sibling::td")
	WebElement OrderDetail_CardType;
	@FindBy(xpath="//div//td[text()='Card Number:']//following-sibling::td")
	WebElement OrderDetail_CardNumber;
	@FindBy(xpath="//div//td[text()='Expiry Date (MM/YYYY):']//following-sibling::td ")
	WebElement OrderDetail_ExpiryDate;
	@FindBy(xpath="//div//h3[text()='Billing Address']")
	WebElement OrderDetail_Billing_Header;
	@FindBy(xpath="(//div//td[text()='First name:']//following-sibling::td)[1]")
	WebElement OrderDetail_Billing_FirstName;
	@FindBy(xpath="(//div//td[text()='Last name:']//following-sibling::td)[1]")
	WebElement OrderDetail_Billing_LastName;
	@FindBy(xpath="(//div//td[text()='Address 1:']//following-sibling::td)[1]")
	WebElement OrderDetail_Billing_Address1;
	@FindBy(xpath="(//div//td[text()='Address 2:']//following-sibling::td)[1]")
	WebElement OrderDetail_Billing_Address2;
	@FindBy(xpath="(//div//td[text()='City:']//following-sibling::td)[1]")
	WebElement OrderDetail_Billing_City;
	@FindBy(xpath="(//div//td[text()='State:']//following-sibling::td)[1]")
	WebElement OrderDetail_Billing_State;
	@FindBy(xpath="(//div//td[text()='Zip:']//following-sibling::td)[1]")
	WebElement OrderDetail_Billing_Zip;
	@FindBy(xpath="(//div//td[text()='Country:']//following-sibling::td)[1]")
	WebElement OrderDetail_Billing_Country;
	@FindBy(xpath="//div//h3[text()='Shipping Address']")
	WebElement OrderDetail_Shipping_Header;
	@FindBy(xpath="(//div//td[text()='First name:']//following-sibling::td)[2]")
	WebElement OrderDetail_Shipping_FirstName;
	@FindBy(xpath="(//div//td[text()='Last name:']//following-sibling::td)[2]")
	WebElement OrderDetail_Shipping_LastName;
	@FindBy(xpath="(//div//td[text()='Address 1:']//following-sibling::td)[2]")
	WebElement OrderDetail_Shipping_Address1;
	@FindBy(xpath="(//div//td[text()='Address 2:']//following-sibling::td)[2]")
	WebElement OrderDetail_Shipping_Address2;
	@FindBy(xpath="(//div//td[text()='City:']//following-sibling::td)[2]")
	WebElement OrderDetail_Shipping_City;
	@FindBy(xpath="(//div//td[text()='State:']//following-sibling::td)[2]")
	WebElement OrderDetail_Shipping_State;
	@FindBy(xpath="(//div//td[text()='Zip:']//following-sibling::td)[2]")
	WebElement OrderDetail_Shipping_Zip;
	@FindBy(xpath="(//div//td[text()='Country:']//following-sibling::td)[2]")
	WebElement OrderDetail_Shipping_Country;
	@FindBy(xpath="//div//td[text()='Courier:']//following-sibling::td")
	WebElement OrderDetail_Shipping_Courier;
	@FindBy(xpath="//div//td[text()='Status:']//following-sibling::td")
	WebElement OrderDetail_Shipping_Status;
	@FindBy(xpath="//table//tr//th[text()='Item ID']//parent::tr//following-sibling::tr//td//a")
	WebElement OrderDetail_Item_ID;
	@FindBy(xpath="//table//tr//th[text()='Item ID']//parent::tr//following-sibling::tr//td//following-sibling::td")
	WebElement OrderDetail_Item_Description;
	@FindBy(xpath="(//table//tr//th[text()='Item ID']//parent::tr//following-sibling::tr//td//following-sibling::td)[2]")
	WebElement OrderDetail_Item_Quantity;
	@FindBy(xpath="(//table//tr//th[text()='Item ID']//parent::tr//following-sibling::tr//td//following-sibling::td)[3]")
	WebElement OrderDetail_Item_Price;
	@FindBy(xpath="(//table//tr//th[text()='Item ID']//parent::tr//following-sibling::tr//td//following-sibling::td)[4]")
	WebElement OrderDetail_Item_Total_Cost;
	@FindBy(xpath="//table//tr//th[text()='Total']//following-sibling::th")
	WebElement OrderDetail_Total_Cost;
	@FindBy(xpath="//div[@class='button-bar']//button[contains(text(),'Delete')]")
	WebElement OrderDetail_Delete_Order;
	
	public OrderDetails(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void OrderDetail_VerifyHeader(String OrderHead,String message) {
		Assert.assertEquals(OrderDetail_Header.getText(), OrderHead);
		Assert.assertEquals(Order_Message_Bar.getText(), message);
	}
	
	public void OrderDetail_VerifyOrderdetails() {
		Assert.assertTrue(OrderDetail_OrderNo.isDisplayed());
		Assert.assertTrue(OrderDetail_OrderDate.isDisplayed());
	}
	
	public void OrderDetail_VerifyPaymentDetails() {
		Assert.assertTrue(OrderDetail_CardType.isDisplayed());
		Assert.assertTrue(OrderDetail_CardNumber.isDisplayed());
		Assert.assertTrue(OrderDetail_ExpiryDate.isDisplayed());
	}
	
	public void OrderDetail_VerifyBillingAddress(String Header,String FirstName,String Lastname,String Address1,String Address2,String City,String Country,String state,String zip) {
		Assert.assertEquals(OrderDetail_Billing_Header.getText(), Header);
		Assert.assertEquals(OrderDetail_Billing_FirstName.getText(), FirstName);
		Assert.assertEquals(OrderDetail_Billing_LastName.getText(), Lastname);
		Assert.assertEquals(OrderDetail_Billing_Address1.getText(), Address1);
		Assert.assertEquals(OrderDetail_Billing_Address2.getText(), Address2);
		Assert.assertEquals(OrderDetail_Billing_City.getText(), City);
		Assert.assertEquals(OrderDetail_Billing_Country.getText(), Country);
		Assert.assertEquals(OrderDetail_Billing_State.getText(), state);
		Assert.assertEquals(OrderDetail_Billing_Zip.getText(), zip);
	}
	
	public void OrderDetail_VerifyShippingAddress(String Header,String FirstName,String Lastname,String Address1,String Address2,String City,String Country,String state,String zip) {
		Assert.assertEquals(OrderDetail_Shipping_Header.getText(), Header);
		Assert.assertEquals(OrderDetail_Shipping_FirstName.getText(), FirstName);
		Assert.assertEquals(OrderDetail_Shipping_LastName.getText(), Lastname);
		Assert.assertEquals(OrderDetail_Shipping_Address1.getText(), Address1);
		Assert.assertEquals(OrderDetail_Shipping_Address2.getText(), Address2);
		Assert.assertEquals(OrderDetail_Shipping_City.getText(), City);
		Assert.assertEquals(OrderDetail_Shipping_Country.getText(), Country);
		Assert.assertEquals(OrderDetail_Shipping_State.getText(), state);
		Assert.assertEquals(OrderDetail_Shipping_Zip.getText(), zip);
		Assert.assertTrue(OrderDetail_Shipping_Courier.isDisplayed());
		Assert.assertTrue(OrderDetail_Shipping_Status.isDisplayed());
	}
	
	public void VerifyOrderHistory(String Item_ID,String Item_Desc,String Item_Price,String Item_Quantity,String Item_TotalCost,String TotalCost) {
		Assert.assertEquals(OrderDetail_Item_ID.getText(), Item_ID);
		Assert.assertEquals(OrderDetail_Item_Description.getText(), Item_Desc);
		Assert.assertTrue(OrderDetail_Item_Price.getText().toString().contains(Item_TotalCost));
		Assert.assertEquals(OrderDetail_Item_Quantity.getText(), Item_Quantity);
		Assert.assertTrue(OrderDetail_Item_Total_Cost.getText().toString().contains(Item_TotalCost));
		Assert.assertTrue(OrderDetail_Total_Cost.getText().toString().contains(TotalCost));
	}
	
	public void DeleteOrder() {
		OrderDetail_Delete_Order.click();
	}
	
	public void Return_to_MainMenu() {
		Return_Link_MainMenu.click();
	}
}
