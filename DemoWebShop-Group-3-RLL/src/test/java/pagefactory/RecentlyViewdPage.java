package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecentlyViewdPage {
	
	
	
	@FindBy(xpath=("(//a[@class='product-name'])[1]"))
	public WebElement first_product_link;
	
	
	
	public RecentlyViewdPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
	}
	
	public String check_first_product_viewd() {
		String first_product_name=first_product_link.getText();
		return first_product_name;
	}
	
	
	public boolean isElementDisplayed(WebElement element) {
		boolean result=element.isDisplayed();
		return result;
	}
}
