package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.DriversInit;

public class SignUpPage{
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement SignUpButton;
	@FindBy(xpath = "//input[@name='username']")
	WebElement UserNameInputBox;
	@FindBy(xpath = "//input[@name='password']")
	WebElement PasswordInputBox;
	@FindBy(xpath = "//input[@name='repeatedPassword']")
	WebElement RepeatePassword;
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement FirstNameTextBox;
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement LastNameTextBox;
	@FindBy(xpath = "//input[@name='email']")
	WebElement EmailTextBox;
	@FindBy(xpath = "//input[@name='phone']")
	WebElement PhoneTextBox;
	@FindBy(xpath = "//input[@name='address1']")
	WebElement Address1TextBox;
	@FindBy(xpath = "//input[@name='address2']")
	WebElement Address2TextBox;
	@FindBy(xpath = "//input[@name='city']")
	WebElement cityTextBox;
	@FindBy(xpath = "//input[@name='state']")
	WebElement stateTextBox;
	@FindBy(xpath = "//input[@name='zip']")
	WebElement zipTextBox;
	@FindBy(xpath = "//input[@name='country']")
	WebElement countryTextBox;
	@FindBy(xpath = "//select[@name='languagePreference']")
	WebElement languageDrop;
	@FindBy(xpath = "//select[@name='favouriteCategoryId']")
	WebElement FavCategoryList;
	@FindBy(xpath = "//input[@name='listOption']")
	WebElement ListCheck;
	@FindBy(xpath = "//input[@name='bannerOption']")
	WebElement Bannercheck;
	@FindBy(xpath = "//button[contains(text(),'Save Account Information')]")
	WebElement SubmitButton;
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Sign_Up_Button() {
		SignUpButton.click();
	}
	public void Language_Selection(String Lang) {
		Select languageList=new Select(languageDrop);
		languageList.selectByVisibleText(Lang);
	}
	public void FavouriteCategory_Selection(String FavouriteCategory) {
		Select FavCategory=new Select(FavCategoryList);
		FavCategory.selectByVisibleText(FavouriteCategory);
	}
	public void Submit_Button() {
		SubmitButton.click();
	}
	
	public void SignUp_Information(String UserName,String Password,String FirstName,String LastName,String Email,String Phone,String Address1,String Address2,String City,String State,String Zipcode,String Country,String Language,String FavouriteCategory) {
		UserNameInputBox.sendKeys(UserName);
		PasswordInputBox.sendKeys(Password);
		RepeatePassword.sendKeys(Password);
		FirstNameTextBox.sendKeys(FirstName);
		LastNameTextBox.sendKeys(LastName);
		EmailTextBox.sendKeys(Email);
		PhoneTextBox.sendKeys(Phone);
		Address1TextBox.sendKeys(Address1);
		Address2TextBox.sendKeys(Address2);
		cityTextBox.sendKeys(City);
		stateTextBox.sendKeys(State);
		zipTextBox.sendKeys(Zipcode);
		countryTextBox.sendKeys(Country);
		Language_Selection(Language);
		FavouriteCategory_Selection(FavouriteCategory);
		ListCheck.click();
		Bannercheck.click();
	}
	
}
