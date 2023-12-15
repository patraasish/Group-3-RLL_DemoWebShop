package stepDefintion;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.BooksPage;
import pagefactory.CheckoutPage;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import pagefactory.ShoppingCartPage;
import utilities.XLS_DataProvider;

public class Checkout_Steps {
	
	WebDriver driver;
	SharedSteps sharedSteps;
	LoginPage loginPage;
	HomePage homePage;
	BooksPage booksPage;
	ShoppingCartPage shoppingCartPage;
	CheckoutPage checkoutPage;
	
	private Object[][] testData;
    static int currentRow = 0;
    
    
    private static final Logger logger =LogManager.getLogger();
	
	public Checkout_Steps(SharedSteps s) {
		this.sharedSteps=s;
	}
	
	@Given("User open the chrome browser and enter URL")
	public void user_open_the_chrome_browser_and_enter_url() {
		driver=sharedSteps.driver;
		homePage=new HomePage(driver);
		loginPage=new LoginPage(driver);
		shoppingCartPage=new ShoppingCartPage(driver);
		booksPage=new BooksPage(driver);
		checkoutPage=new CheckoutPage(driver);
	    driver.get(sharedSteps.web_url);
	    String actual_url=driver.getCurrentUrl();
	    Assert.assertEquals(actual_url, sharedSteps.web_url);
	}

	@When("User click on login")
	public void user_click_on_login() {
		boolean result=loginPage.isElementDisplayed(loginPage.link_login);
		assertTrue(result);
		loginPage.clickLoginLink();
		logger.info("User click on login");
		
	}

	
	@Then("User enter email {string}")
	public void user_enter_email(String email) throws EncryptedDocumentException, IOException {
		testData = XLS_DataProvider.getTestData("Sheet1");
		email = (String) testData[currentRow][0];
		loginPage.enter_email(email);
		logger.info("User enter email");
	}

	@Then("User enter password {string}")
	public void user_enter_password(String password) throws EncryptedDocumentException, IOException {
		testData = XLS_DataProvider.getTestData("Sheet1");
		password = (String) testData[currentRow][1];
		loginPage.enter_password(password);
		logger.info("User enter password");
	}

	
	@Then("User click on login button")
	public void user_click_on_login_button() {
		loginPage.clickLoginButton();
		logger.info("User click login");
	}

	@When("User click on books tab")
	public void user_click_on_books_tab() {
	  homePage.click_on_Book_Btn();
	  logger.info("User click on book tab");
	}

	@Then("User click on third book")
	public void user_click_on_third_book() throws InterruptedException {
	Thread.sleep(7000);
	booksPage.Click_on_third_book();
	logger.info("User click on third book");
	}

	@Then("User click on Add to cart button")
	public void user_click_on_add_to_cart_button() throws InterruptedException {
	  Thread.sleep(3000);
	  booksPage.Book_AddToCart_Btn.click();
	  logger.info("User click on Add to cart button");
	}

	@When("User click on shopping cart page")
	public void user_click_on_shopping_cart_page() throws InterruptedException {
	  Thread.sleep(3000);
	   booksPage.shopping_cart_Btn.click();
	   logger.info("User click on shopping cart page");
	}
	

	@Then("User Click on terms of service check box")
	public void user_click_on_terms_of_service_check_box() throws InterruptedException {
	  Thread.sleep(3000);
	  shoppingCartPage.term_And_Service.click();
	  logger.info("User Click on terms of service check box");
	}

	@Then("User click on checkout button")
	public void user_click_on_checkout_button() throws InterruptedException {
		Thread.sleep(3000);
	   shoppingCartPage.Checkout_Btn.click();
	   logger.info("User click on checkout button");
	}


	@When("User Fill The Billing Address Form")
	public void user_fill_the_billing_address_form() throws InterruptedException, EncryptedDocumentException, IOException {
		checkoutPage.billing_Address_box.click();
		Thread.sleep(7000);
		checkoutPage.Select_New_Address_box.click();
		Thread.sleep(4000);
		checkoutPage.country_select_box.click();
		Thread.sleep(4000);
		checkoutPage.select_india.click();
		Thread.sleep(4000);
		testData = XLS_DataProvider.getTestData("Sheet2");
		String city = (String) testData[0][0];
		String address=(String) testData[0][1];
		String pincode=(String) testData[0][2];
		String phonenumber=(String) testData[0][3];
		
		checkoutPage.billing_Address_city.sendKeys(city);
		checkoutPage.billing_Address_Adress1.sendKeys(address);
		checkoutPage.billing_Address_pincode.sendKeys(pincode);
		checkoutPage.billing_Address_phonenumber.sendKeys(phonenumber);
		logger.info("User Fill The Billing Address Form");
	}

	@Then("User click on Billing Address Continue button")
	public void user_click_on_billing_address_continue_button() throws InterruptedException {
		Thread.sleep(5000);
		checkoutPage.Billing_Address_Continue_Btn.click();
		logger.info("User click on Billing Address Continue button");
	}

	@Then("User click on  In Store Pickup check box")
	public void user_click_on_in_store_pickup_check_box() throws InterruptedException {
		Thread.sleep(5000);
	   checkoutPage.pick_Up_CheckBox.click();
	   logger.info("User click on  In Store Pickup check box");
	}

	@Then("User click on Shipping Address Continue button")
	public void user_click_on_shipping_address_continue_button() throws InterruptedException {
		Thread.sleep(7000);
	 checkoutPage.pick_Up_Continue_Btn.click();
	 logger.info("User click on Shipping Address Continue button");

	}

	@Then("User click on first image")
	public void user_click_on_first_image() throws InterruptedException {
		Thread.sleep(5000);
	checkoutPage.payment_Option.click();
	 logger.info("User click on first image");
	}

	@Then("User click on Payment Method Continue button")
	public void user_click_on_payment_method_continue_button() throws InterruptedException {
		Thread.sleep(5000);
	 checkoutPage.payment_method_continue.click();
	 logger.info("User click on Payment Method Continue button");
	}


	@Then("User click on Payment Information Continue button")
	public void user_click_on_payment_information_continue_button() throws InterruptedException {
		Thread.sleep(5000);
	    checkoutPage.payment_info_continue.click();
	    logger.info("User click on Payment Information Continue button");
	}


	@When("User click on confirm button")
	public void user_click_on_confirm_button() throws InterruptedException {
		Thread.sleep(5000);
	   checkoutPage.confirm_order.click();
	   logger.info("User click on confirm button");
	}

	@Then("User should see the successfull message")
	public void user_should_see_the_successfull_message() throws InterruptedException {
		Thread.sleep(5000);
	   String Expected_message="Your order has been successfully processed!";
		String Actual_message=checkoutPage.success_msg.getText();
	    logger.info(Actual_message);
	    Assert.assertEquals(Actual_message, Expected_message);
	    
	}
}
