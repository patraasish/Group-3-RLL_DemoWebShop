package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

	@FindBy(linkText ="Digital downloads")
	public WebElement Digital_download_Link;
	
	@FindBy(xpath=("//a[@class='ico-wishlist'][1]"))
	public WebElement wishlist_Btn;
	
	@FindBy(xpath=("//a[@href='/books']"))
	public WebElement Book_Btn;
	
	@FindBy(xpath=("//a[@class='product-name'][1]"))
	public WebElement recently_viewed_product_name;

	@FindBy(xpath=("//h2[@class='product-title']/a[text()='14.1-inch Laptop']"))
	public WebElement laptop_link;
	
	
	//// Locators for community poll
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[1]/strong")
	static WebElement poll_display;
		
	@FindBy(xpath="//*[@id=\"pollanswers-1\"]")
	static WebElement choose_btn;
	
	@FindBy(xpath="//*[@id=\"vote-poll-1\"]")
	static WebElement vote_btn;
	
	
    @FindBy(xpath = "//*[@id=\"block-poll-vote-error-1\"]")
    WebElement message_btn;
    
    
    public void dispalyPoll() {
  		Assert.assertTrue(poll_display.isDisplayed(),"Message button is not displayed");
	  	}
    
    public void voteBtn() {
		choose_btn.click();
		vote_btn.click();
		
	}
    
    public boolean message() {
  	  // Check if the message button is displayed
  	  try {
  	    Assert.assertTrue(message_btn.isDisplayed(), "Message button is not displayed");
  	  } catch (AssertionError e) {
  	    // Log the error message
  	   // System.out.println(e.getMessage());
  	    return false;
  	  }
  	  return true;
  	
  }

	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
	}
	
	
	public void click_on_Digital_Download() {
		Digital_download_Link.click();
	}
	
	
	public void click_on_Wishlist_link() {
		wishlist_Btn.click();
	}
	
	public void click_on_Book_Btn() {
		Book_Btn.click();
	}
	
	public void click_on_laptop_link() {
		laptop_link.click();
	}
		
	
	
	public boolean isElementDisplayed(WebElement element) {
		boolean result=element.isDisplayed();
		return result;
	}
}
