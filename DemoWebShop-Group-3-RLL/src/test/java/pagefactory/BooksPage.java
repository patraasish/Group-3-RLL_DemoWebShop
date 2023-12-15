package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage {
	
	@FindBy(xpath=("//a[text()='Computing and Internet']"))
	public WebElement book_link;
	
	
	@FindBy(xpath=("//img[@alt='Tricentis Demo Web Shop']"))
	public WebElement home_link;
	
	@FindBy(xpath=("(//input[@class='button-2 product-box-add-to-cart-button'])[2]"))
	public WebElement third_book_addToCart;
	
	@FindBy(xpath=("//p[@class='content']"))
	public WebElement message;
	
	
	@FindBy(linkText = "Shopping cart")
	public WebElement shopping_cart_Btn;
	
	//book-1
	@FindBy(xpath ="//img[@alt='Picture of Computing and Internet']")
	public WebElement first_book;
	
	//book-2
	@FindBy(xpath ="//img[@alt='Picture of Copy of Computing and Internet EX']")
	public WebElement second_book;
	
	//book-3
	@FindBy(xpath ="(//img[@alt='Picture of Fiction'])")
	public WebElement third_book;
	
	//book-4
	@FindBy(xpath ="(//img[@alt='Picture of Fiction EX'])")
	public WebElement fourth_book;
	
	//book-5
	@FindBy(xpath ="(//img[@alt='Picture of Health Book'])")
	public WebElement fifth_book;
	
	//book-6
	@FindBy(xpath ="(//img[@alt='Picture of Science'])")
	public WebElement sixth_book;
	
	@FindBy(xpath=("//div[@class='add-to-cart-panel']"))
	public WebElement Book_AddToCart_Btn;
		
	@FindBy(xpath="(//img[@title='Show details for Fiction'])")
	public WebElement third_book_for_checkout_path1;
	
	@FindBy(xpath="(//img[@title='Show details for Fiction'])[2]")
	public WebElement third_book_for_checkout_path2;
	
	public void Click_on_third_book() {
		try {
			third_book_for_checkout_path1.click();
		}
		catch (org.openqa.selenium.ElementNotInteractableException e) {
			third_book_for_checkout_path2.click();
		}
	}
	
	public void click_on_shopping_cart_Btn() {
		shopping_cart_Btn.click();
	}
	
	public void click_on_book_link() {
		book_link.click();
	}
	
	public void third_book_addToCart() {
		third_book_addToCart.click();
	}
	
	public void click_on_home_link() {
		home_link.click();
	}
	
	public String get_Success_Message() {
		String msg=message.getText();
		return msg;
	}
	
	public boolean isElementDisplayed(WebElement element) {
		boolean result=element.isDisplayed();
		return result;
	}
	
	public BooksPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
	}
}
