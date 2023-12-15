package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	@FindBy(xpath=("//img[@src='https://demowebshop.tricentis.com/content/images/thumbs/0000133_fiction_80.jpeg']"))
	public WebElement third_book;
	
	@FindBy(xpath=("//input[@id='termsofservice']"))
	public WebElement term_And_Service;
	
	@FindBy(xpath=("//button[@id='checkout']"))
	public static WebElement Checkout_Btn;
	
	public boolean isElementDisplayed(WebElement element) {
		boolean result=element.isDisplayed();
		return result;
	}
	
	public ShoppingCartPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
	}
}
