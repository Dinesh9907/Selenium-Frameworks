package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.PaymentPage;
import Utility.DriversInit;
import Utility.ReadProp;

public class PaymentTest extends DriversInit{
	
	String PaymentHeader="Payment Details";
	String BillingHeader="Billing Address";
	ReadProp readString=new ReadProp();
	
	@Test(dependsOnMethods = "Tests.ShoppingCartTest.ShoppingTest")
	public void paymentDetails() throws IOException {
		String CardType=readString.propReader("CardType");
		String Cardnumber=readString.propReader("Cardnumber");
		String ExpiryDate=readString.propReader("ExpiryDate");
		String FirstName=readString.propReader("FirstName");
		String LastName=readString.propReader("LastName");
		String Address1=readString.propReader("Address1");
		String Address2=readString.propReader("Address2");
		String City=readString.propReader("City");
		String State=readString.propReader("state");
		String Country=readString.propReader("Country");
		String zip=readString.propReader("zip");
		
		PaymentPage payment=new PaymentPage(driver);
		payment.PaymentDetails(PaymentHeader,CardType,Cardnumber,ExpiryDate);
		payment.BillingDetails(BillingHeader,FirstName,LastName,Address1,Address2,City,State,Country,zip);
		payment.PaymentPage_Continue();
	}
	
}
