package stepDefintion;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.BooksPage;
import pagefactory.HomePage;
import pagefactory.ShoppingCartPage;

public class DemoWebShopAddToCartStepDefs {
	
	SharedSteps sharedSteps;
	BooksPage booksPage;
	HomePage homePage; 
	WebDriver driver;
	ShoppingCartPage shoppingCartPage;
	
	private static final Logger logger =LogManager.getLogger();
	
	
	public DemoWebShopAddToCartStepDefs (SharedSteps sharedSteps) {
		this.sharedSteps = sharedSteps;
	}
	
	
	
	@Given("User open on demoshop url")
	public void user_open_on_demoshop_url() throws IOException {
		
		logger.info("Inside User open on demoshop url steps");
		
		driver=sharedSteps.driver;
	    homePage=new HomePage(driver); 
	    booksPage=new BooksPage(driver);
	    shoppingCartPage=new ShoppingCartPage(driver);
	    driver.get(sharedSteps.web_url);
	    String expected_url=sharedSteps.web_url;
	    String actual_url=driver.getCurrentUrl();
	    Assert.assertEquals(actual_url, expected_url);
	}

	@Then("User click on the book")
	public void user_click_on_the_book() {
		logger.info("Inside User click on the book steps");
	   homePage.click_on_Book_Btn();
	}

	@When("User add the third book to the cart")
	public void user_add_the_third_book_to_the_cart() {
		logger.info("Inside User add the third book to the cart steps");
	   booksPage.third_book_addToCart();
	}

	@Then("The User should see a confirmation message")
	public void the_user_should_see_a_confirmation_message() throws InterruptedException {
		logger.info("The User should see a confirmation message");
		Thread.sleep(1000);
		String ExpectedMessage="The product has been added to your shopping cart";
		String ActualMessage=booksPage.get_Success_Message();
		Assert.assertEquals(ActualMessage, ExpectedMessage);
	}

	@Then("User click on shopping cart")
	public void user_click_on_shopping_cart() {
		logger.info("User click on shopping cart");
		booksPage.click_on_shopping_cart_Btn();
	}

	@Then("User should see that product available in shopping cart")
		public void user_should_see_that_product_available_in_shopping_cart() {
		logger.info("User should see that product available in shopping cart");
		boolean result=shoppingCartPage.isElementDisplayed(shoppingCartPage.third_book);
		assertTrue(result);
	}

}
