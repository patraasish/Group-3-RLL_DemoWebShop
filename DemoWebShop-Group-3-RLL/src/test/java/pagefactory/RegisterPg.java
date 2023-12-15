package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPg{

	@FindBy (xpath="//a[text()='Register']")
	WebElement registerClick;

	@FindBy (id="gender-male")
	WebElement genderClick;

	@FindBy (id="FirstName")
	WebElement firstNameClick;

	@FindBy (id="LastName")
	WebElement lastNameClick;

	@FindBy (id="Email")
	WebElement emailClick;

	@FindBy (id="Password")
	WebElement passwordClick;

	@FindBy (id="ConfirmPassword")
	WebElement confirmPasswordClick;

	@FindBy (xpath="//span[@for = 'ConfirmPassword']")
	public WebElement cperror;
	

	@FindBy (id="register-button")
	 WebElement registerButtonClick;
	
	@FindBy (xpath = "(//div[@class = 'validation-summary-errors'])/ul/li")
	 public WebElement mailerr;
	
	

	public RegisterPg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}

	public void getRegisterClick() {
		registerClick.click();
	}

	public void getGenderClick() {
		genderClick.click();
	}

	public void getFirstNameClick(String fname) {
		firstNameClick.sendKeys(fname);
	}

	public void getLastNameClick(String lname) {
		lastNameClick.sendKeys(lname);
	}

	public void getEmailClick(String email) {
		 emailClick.sendKeys(email);
	}

	public void getPasswordClick(String password) {
		passwordClick.sendKeys(password);
	}

	public void getConfirmPasswordClick(String confirmPassword) {
		confirmPasswordClick.sendKeys(confirmPassword);
	}

	public void getRegisterButtonClick() {
		 registerButtonClick.click();
	}
	public String getmessage(WebElement element) {
		return element.getText();
	}
	
	
}
