package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	@FindBy(xpath="//input[@onclick='Billing.save()']")
	public WebElement Billing_Address_Continue_Btn;
	
	
	@FindBy(xpath="//input[@id='PickUpInStore']")
	public WebElement pick_Up_CheckBox;
		
	@FindBy(xpath="//input[@onclick='Shipping.save()']")
	public WebElement pick_Up_Continue_Btn;	
	
	@FindBy(xpath="//input[@id='shippingoption_0']")
	public WebElement shipping_option_CheckBox;
	
	@FindBy(xpath="//input[@onclick='ShippingMethod.save()']")
	public WebElement shipping_Continue_Btn;
	
	@FindBy(xpath="//input[@id='paymentmethod_0']")
	public WebElement payment_Option;
	
	
	@FindBy(xpath="//input[@onclick='PaymentMethod.save()']")
	public WebElement payment_method_continue;
	
	@FindBy(xpath="//input[@onclick='PaymentInfo.save()']")
	public WebElement payment_info_continue;
	
	@FindBy(xpath="//input[@onclick='ConfirmOrder.save()']")
	public WebElement confirm_order;
	
	/////////////
	
	@FindBy(xpath="//select[@id='billing-address-select']")
	public WebElement billing_Address_box;
	//option[text()='New Address']

	//City path
	//select country
	@FindBy(xpath="//select[@id='BillingNewAddress_CountryId']")
	public WebElement country_select_box;
	
	//India
	@FindBy(xpath="//option[@value='41']")
	public WebElement select_india;
	
	@FindBy(xpath="	//option[text()='New Address']")
	public WebElement Select_New_Address_box;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_City']")
	public WebElement billing_Address_city;
	
	//Adress1
	@FindBy(xpath="//input[@id='BillingNewAddress_Address1']")
	public WebElement billing_Address_Adress1;
	
	//pincode
	@FindBy(xpath="//input[@id='BillingNewAddress_ZipPostalCode']")
	public WebElement billing_Address_pincode;
	
	//phone number
	@FindBy(xpath="//input[@id='BillingNewAddress_PhoneNumber']")
	public WebElement billing_Address_phonenumber;
	
	
	@FindBy(xpath="//strong")
	public WebElement success_msg;
	
	public CheckoutPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
	}
}
