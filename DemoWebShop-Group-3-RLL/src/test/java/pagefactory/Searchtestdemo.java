package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchtestdemo {
	
	@FindBy(xpath="//input[@id='small-searchterms']")
	public WebElement Searchbar;
	@FindBy(xpath="//input[@class='button-1 search-box-button']")
	public WebElement Searchbutton;
	@FindBy(xpath=("/html/body/div[4]/div[1]/div[1]/div[1]/a/img"))
	public WebElement Backtohomepage;
	
	
	public void clickonsearch()
	{
		Searchbar.click();
	}
	
	
	public void writeonsearch(String Itemtosearch) throws InterruptedException
	{	
		Searchbar.sendKeys(Itemtosearch);
		Thread.sleep(1000);		
	}
	public void clickonbutton() throws InterruptedException
	{
		Searchbutton.click();
		Thread.sleep(1500);
	}
	public void clickonlogo()
	{
		Backtohomepage.click();
	}
	
	
     public Searchtestdemo(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
}
