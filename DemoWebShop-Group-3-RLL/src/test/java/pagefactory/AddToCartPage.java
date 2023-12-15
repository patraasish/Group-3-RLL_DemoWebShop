package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
		
	@FindBy(xpath=("(//div[contains(@class,'button')])[3]"))
	public static WebElement first_Book_AddToCart_Btn;
	
	@FindBy(xpath=("(//div[contains(@class,'button')])[4]"))
	public static WebElement second_Book_AddToCart_Btn;
	
	@FindBy(xpath=("(//div[contains(@class,'button')])[5]"))
	public static WebElement third_Book_AddToCart_Btn;
	
	@FindBy(xpath=("(//div[contains(@class,'button')])[6]"))
	public static WebElement fourth_Book_AddToCart_Btn;
	
	@FindBy(xpath=("(//div[contains(@class,'button')])[7]"))
	public static WebElement fifth_Book_AddToCart_Btn;
	
	@FindBy(xpath=("(//div[contains(@class,'button')])[8]"))
	public static WebElement sixth_Book_AddToCart_Btn;
	
	public AddToCartPage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
			// driver can now work with your elements and methods of this class
		}
//	public void click_on_first_book() {
//			first_Book.click();
//		}
//		
//	public void click_on_second_book() {
//			second_Book.click();
//		}
//		
//	public void click_on_third_book() {
//			third_Book.click();
//		}
//	public void click_on_fouth_book() {
//			fourth_Book.click();
//		}
//		
//	public void click_on_fifth_book() {
//			fifth_Book.click();
//		}
		
//	public void click_on_sixth_book() {
//			sixth_Book.click();
//		}
//	public void click_on_first_Book_AddToCart_Btn() {
//			first_Book_AddToCart_Btn.click();
//		 }
//		 
//	 public void click_on_thrid_Book_AddToCart_Btn() {
//			 thrid_Book_AddToCart_Btn.click();
//		 }
//		 
//	 public void click_on_third_Products_AddToCart_Btn() {
//			 fifty_Book_AddToCart_Btn.click();
//		 }
//		 
		 
//	 public String getSuccessMessage() {
//			 String msg=success_message.getText();
//			 return msg;
//		 }
//			
////    public boolean is_displayed_first_Book_AddToCart_Btn() {
//		boolean b= first_Book_AddToCart_Btn.isDisplayed();
//		return b;
//		
//	}
//	 
//	 public boolean is_displayed_thrid_Book_AddToCart_Btn() {
//		boolean b= thrid_Book_AddToCart_Btn.isDisplayed();
//		 return b;
//	 }
//	 
//	 public boolean is_displayed_fifth_Book_AddToCart_Btn() {
//		 boolean b=fifty_Book_AddToCart_Btn.isDisplayed();
//		 return b;
//	 }

}
