package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.OrderDetails;
import Utility.DriversInit;
import Utility.ReadProp;

public class OrderDetailTest extends DriversInit{
	
	String Message="Thank you, your order has been submitted.";
	String OrderHead="Order";
	String BillingHead="Billing Address";
	String ShippingHead="Shipping Address";
	ReadProp readString=new ReadProp();
	
	@Test(dependsOnMethods = "Tests.OrderConfirmTest.OrderConfirm")
	public void OrderDetail() throws IOException {
		
		String FirstName=readString.propReader("FirstName");
		String LastName=readString.propReader("LastName");
		String Address1=readString.propReader("Address1");
		String Address2=readString.propReader("Address2");
		String City=readString.propReader("City");
		String state=readString.propReader("state");
		String zip=readString.propReader("zip");
		String Country=readString.propReader("Country");
		String ItemId=readString.propReader("ItemID");
		String ItemDesc=readString.propReader("ItemDesc");
		int Quantity=Integer.parseInt(readString.propReader("Quantity"));
		double ItemCost=Double.parseDouble(readString.propReader("ItemCost"));
		double totalCost=ItemCost*Quantity;
		double total=totalCost;
		
		OrderDetails orderDet=new OrderDetails(driver);
		orderDet.OrderDetail_VerifyHeader(OrderHead,Message);
		orderDet.OrderDetail_VerifyOrderdetails();
		orderDet.OrderDetail_VerifyPaymentDetails();
		orderDet.OrderDetail_VerifyBillingAddress(BillingHead,FirstName, LastName, Address1, Address2, City, Country, state, zip);
		orderDet.OrderDetail_VerifyShippingAddress(ShippingHead,FirstName, LastName, Address1, Address2, City, Country, state, zip);
		orderDet.VerifyOrderHistory(ItemId,ItemDesc,String.valueOf(ItemCost),String.valueOf(Quantity),String.valueOf(totalCost),String.valueOf(total));
		orderDet.DeleteOrder();
	}
}
