package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.OrderConfirmationPage;
import Utility.DriversInit;
import Utility.ReadProp;

public class OrderConfirmTest extends DriversInit{
	
	String OrderHead="Order";
	String Message="Please confirm the information below and then press continue...";
	ReadProp readString=new ReadProp();
	
	@Test(dependsOnMethods = "Tests.PaymentTest.paymentDetails")
	public void OrderConfirm() throws IOException {
		String FirstName=readString.propReader("FirstName");
		String LastName=readString.propReader("LastName");
		String Address1=readString.propReader("Address1");
		String Address2=readString.propReader("Address2");
		String City=readString.propReader("City");
		String state=readString.propReader("state");
		String zip=readString.propReader("zip");
		String Country=readString.propReader("Country");
		
		OrderConfirmationPage orderconfirm=new OrderConfirmationPage(driver);
		orderconfirm.OrderConfirm_VerifyHeader(OrderHead,Message);
		orderconfirm.OrderConfirm_VerifyOrderdetails();
		orderconfirm.OrderConfirm_VerifyBillingAddress(FirstName, LastName, Address1, Address2, City, Country, state, zip);
		orderconfirm.OrderConfirm_VerifyShippingAddress(FirstName, LastName, Address1, Address2, City, Country, state, zip);
		orderconfirm.OrderConfirm_Button();
	}
}
