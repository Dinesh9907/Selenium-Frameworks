package Tests;

import org.testng.annotations.Test;

import Pages.OrderPlacementPage;
import Utility.DriversInit;

public class OrderPlaceTest extends DriversInit {
	
	String catagory="Fish";
	String Product="Koi";
	String SubProduct="Spotted";
	
	@Test(dependsOnMethods = "Tests.SignInTest.signIn" )
	public void placeOrder() {
		OrderPlacementPage orderPlace=new OrderPlacementPage(driver);
		orderPlace.Catagory_Link(catagory);
		orderPlace.CatagoryPage_Validation(catagory);
		orderPlace.Product_Link(Product);
		orderPlace.SubProduct_Link(SubProduct);
		orderPlace.SubProduct_Page_Validation(SubProduct);
		orderPlace.SubProduct_AddToCart_Button();
	}
}
