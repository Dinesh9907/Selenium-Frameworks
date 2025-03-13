package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.SignUpPage;
import Utility.DriversInit;
import Utility.ReadProp;

public class SignUpTest extends DriversInit{
	
	ReadProp readString=new ReadProp();
	
	@Test
	public void SignUp() throws InterruptedException, IOException {
		String UserName=readString.propReader("UserName");
		String Password=readString.propReader("Password");
		String FirstName=readString.propReader("FirstName");
		String LastName=readString.propReader("LastName");
		String Email=readString.propReader("Email");
		String Phone=readString.propReader("Phone");
		String Address1=readString.propReader("Address1");
		String Address2=readString.propReader("Address2");
		String City=readString.propReader("City");
		String state=readString.propReader("state");
		String zip=readString.propReader("zip");
		String Country=readString.propReader("Country");
		SignUpPage signuptest=new SignUpPage(driver);
		Assert.assertEquals(driver.getTitle(), "JPetStore Demo");
		signuptest.Sign_Up_Button();
		signuptest.SignUp_Information(UserName, Password, FirstName, LastName, Email, Phone, Address1, Address2, City, state, zip, Country, "English","Fish");
		signuptest.Submit_Button();
		Thread.sleep(5000);
	}
}
