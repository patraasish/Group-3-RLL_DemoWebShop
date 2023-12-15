package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	
	@FindBy(linkText="Log in")
	public WebElement link_login;
	
	@FindBy(id="Email")
	public static WebElement Txtbox_Username;
	
	@FindBy(id="Password")
	public static WebElement Txtbox_Password;
	
	@FindBy(xpath="//input[@value='Log in']")
	public static WebElement Btn_login;
	
	///Community poll Locators
	@FindBy(xpath="//*[@id=\"pollanswers-1\"]")
	public static WebElement chooose_btn;

    @FindBy(xpath="//*[@id=\"vote-poll-1\"]")
	public  WebElement vote_btn;

    @FindBy(xpath="//strong[text()='Community poll']")
  	public static WebElement polll_display;
    
    @FindBy(xpath="//*[@id=\"poll-block-1\"]/ul/li[1]")
	public static WebElement percentage_btn;
	
	//community poll Locators
    
      public void pollDisplay() {
    	  Assert.assertTrue(polll_display.isDisplayed(),"Message button is not displayed");
    	 
      }
  	
    public void clickLinkLogin() {
    	link_login.click(); 
    	}

  
    public void clickLoginButton() {
    	Btn_login.click();
    	
    
    }
   
    
    public void percentage() {
		Assert.assertTrue(percentage_btn.isDisplayed(),"Message button is not displayed");
		 
	  }
  
	
	public void clickLoginLink() {
		link_login.click();
	}
	
	public void enter_email(String email) {
		Txtbox_Username.sendKeys(email);
		}
	
	public void enter_password(String password) {
		Txtbox_Password.sendKeys(password);
	}
	
	public void clickLoginsubmitButton() {
		Btn_login.click();
	}
	
	public boolean isElementDisplayed(WebElement element) {
		boolean result=element.isDisplayed();
		return result;
	}
	
	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
	}
	
}
