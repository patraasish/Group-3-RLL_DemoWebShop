package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {
	
	
	@FindBy(xpath="(//input[contains(@name,'removefromcart')])[1]")
	public WebElement remove_first_Product;

	@FindBy(xpath="(//input[contains(@name,'removefromcart')])[2]")
	public WebElement remove_second_Product;

	@FindBy(xpath="(//input[contains(@name,'removefromcart')])[3]")
	public WebElement remove_third_Product;
	
	@FindBy(xpath=("//input[@value='Update wishlist']"))
	public  WebElement update_wishlist_Btn;
	
	
	@FindBy(xpath=("//div[@class='wishlist-content']"))
	public  WebElement empty_Message;
	
	public void click_on_remove_first_product() {
		remove_first_Product.click();
	}
	
	public void click_on_remove_second_product() {
		remove_second_Product.click();
	}
	
	public void click_on_remove_third_product() {
		remove_third_Product.click();
	}
	
	public void click_on_update_wishlist_Btn() {
		update_wishlist_Btn.click();
	}
	
	public String get_Empty_Message() {
		String msg=empty_Message.getText();
		return msg;
	}
	public boolean isElementDisplayed(WebElement element) {
		boolean result=element.isDisplayed();
		return result;
	}
	public WishlistPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
	}
}
