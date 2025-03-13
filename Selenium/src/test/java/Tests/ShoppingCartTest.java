package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.ShoppingCartPage;
import Utility.DriversInit;
import Utility.ReadProp;

public class ShoppingCartTest extends DriversInit{
	
	String header="Shopping Cart";
	int total=1;
	ReadProp readString=new ReadProp();
	
	@Test(dependsOnMethods = "Tests.OrderPlaceTest.placeOrder")
	public void ShoppingTest() throws IOException {
		String ItemID=readString.propReader("ItemID");
		ShoppingCartPage shoppingcart=new ShoppingCartPage(driver);
		shoppingcart.ShoppingCartPage_Validation(header,ItemID);
		shoppingcart.ShoppingCart_UpdateCart(1,18.5,ItemID);
		shoppingcart.ValidateButtons(total);
		shoppingcart.ActualSubTotalAmount_Validation();
		shoppingcart.CheckOut_Button();
	}
}
