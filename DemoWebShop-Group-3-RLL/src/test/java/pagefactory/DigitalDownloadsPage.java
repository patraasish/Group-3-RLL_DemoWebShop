package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DigitalDownloadsPage {

	
	@FindBy(xpath=("//img[@title='Show details for 3rd Album']"))
	public  WebElement first_Product;
	
	@FindBy(xpath=("//img[@title='Show details for Music 2']"))
	public  WebElement second_Product;
	
	@FindBy(xpath=("//img[@src='https://demowebshop.tricentis.com/content/images/thumbs/0000236_music-2_125.png']"))
	public  WebElement third_Product;
	
	
	@FindBy(xpath=("//input[@id='add-to-wishlist-button-53']"))
	public  WebElement first_Products_Wishlist_Btn;
	
	@FindBy(xpath=("//input[@id='add-to-wishlist-button-51']"))
	public  WebElement second_Products_Wishlist_Btn;
	
	@FindBy(xpath=("//input[@id='add-to-wishlist-button-52']"))
	public  WebElement third_Products_Wishlist_Btn;
	
	
	@FindBy(xpath=("//div[@id=\"bar-notification\"]/p"))
	public  WebElement success_message;
	
	 public DigitalDownloadsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
	}
	 
	 
	 public void click_on_first_product() {
		 first_Product.click();
	 }
	 
	 public void click_on_second_product() {
		 second_Product.click();
	 }
	 
	 public void click_on_third_product() {
		 third_Product.click();
	 }
	 
	 public void click_on_first_Products_Wishlist_Btn() {
		first_Products_Wishlist_Btn.click();
	 }
	 
	 public void click_on_second_product_wishlist_Btn() {
		 second_Products_Wishlist_Btn.click();	 
	 }
	 
	 public void click_on_third_Products_Wishlist_Btn() {
		 third_Products_Wishlist_Btn.click();
	 }
	 
	 
	 public String getSuccessMessage() {
		 String msg=success_message.getText();
		 return msg;
	 }
	 
	 
	 public boolean isElementDisplayed(WebElement element) {
			boolean result=element.isDisplayed();
			return result;
		}
}
