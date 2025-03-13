package Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v126.css.model.CSSStyleSheetHeader;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.SignInPage;
import Utility.DriversInit;
import Utility.ReadProp;

public class SignInTest extends DriversInit{
	ReadProp readString=new ReadProp();
	
	@Test(dependsOnMethods = "Tests.SignUpTest.SignUp")
	public void signIn() throws InterruptedException, IOException {
		String UserName=readString.propReader("UserName");
		String Password=readString.propReader("Password");
		SignInPage signintest=new SignInPage(driver);
		Assert.assertEquals(signintest.MessageBar(), "Your account has been created. Please try login.");
		signintest.SignIn_Creds(UserName, Password);
		signintest.SignIn_Submit_Button();
		Thread.sleep(2000);
	}
}
