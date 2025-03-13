package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver;
	
	
	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	WebElement SignInButton;
	@FindBy(xpath = "//input[@name='username']")
	WebElement UserNameTextField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement PasswordTextField;
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	WebElement SignInSubmitButton;
	@FindBy(xpath = "//div[@id='MessageBar']//p")
	WebElement MessageBar;
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void Sign_In_Button() {
		SignInButton.click();
	}
	
	public void SignIn_Submit_Button() {
		SignInSubmitButton.click();
	}
	
	public void SignIn_Creds(String UserName,String Password) {
		UserNameTextField.clear();
		PasswordTextField.clear();
		UserNameTextField.sendKeys(UserName);
		PasswordTextField.sendKeys(Password);
	}
	
	public String MessageBar() {
		return MessageBar.getText();
	}
	
}
