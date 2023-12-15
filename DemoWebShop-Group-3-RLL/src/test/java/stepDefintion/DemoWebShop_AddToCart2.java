package stepDefintion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.BooksPage;
import pagefactory.HomePage;

public class DemoWebShop_AddToCart2 {
	
	SharedSteps sharedSteps;
	BooksPage booksPage;
	HomePage homePage; 
	WebDriver driver;
	
	
	private static final Logger logger =LogManager.getLogger();
	
	
	public DemoWebShop_AddToCart2 (SharedSteps sharedSteps) {
		this.sharedSteps = sharedSteps;
	}
	
	@Given("Navigate to url")
	public void navigate_to_url() {
		
		logger.info("Inside User open on demoshop url steps");
		
		driver=sharedSteps.driver;
	    homePage=new HomePage(driver); 
	    booksPage=new BooksPage(driver);
	     driver.get(sharedSteps.web_url);
	   
	    String expected_url=sharedSteps.web_url;
	    String actual_url=driver.getCurrentUrl();
	    Assert.assertEquals(actual_url, expected_url);
	}

	@When("I click on book link")
	public void i_click_on_book_link() throws InterruptedException {
		logger.info("click on the book");
		homePage.click_on_Book_Btn();
		Thread.sleep(1000);
	}

	@Then("I verify first book have Add to Cart button")
	public void i_verify_first_book_have_add_to_cart_button() {
		
	 booksPage.first_book.click();

	 try {
		 boolean isShow=booksPage.isElementDisplayed(booksPage.Book_AddToCart_Btn);
		 logger.info("first book have add to cart button"+isShow);
     } catch (org.openqa.selenium.NoSuchElementException e) {
         System.out.println("The 1st book does not contain an add to cart button.");
     }
	  	  
	}

	@Then("I verify second book have Add to Cart button")
	public void i_verify_second_book_have_add_to_cart_button() throws InterruptedException {
		homePage.click_on_Book_Btn();
		Thread.sleep(1000);
		booksPage.second_book.click();
		Thread.sleep(1000);
		 try {
			 boolean isShow=booksPage.isElementDisplayed(booksPage.Book_AddToCart_Btn);
			 logger.info("second book have add to cart button"+isShow);
	     } catch (org.openqa.selenium.NoSuchElementException e) {
	         System.out.println("The 2nd book does not contain an add to cart button.");
	     }
	}

	@Then("I verify third book have Add to Cart button")
	public void i_verify_third_book_have_add_to_cart_button() throws InterruptedException {
		homePage.click_on_Book_Btn();
		Thread.sleep(1000);
		booksPage.third_book.click();
		Thread.sleep(3000);
		 try {
			 boolean isShow=booksPage.isElementDisplayed(booksPage.Book_AddToCart_Btn);
			 logger.info("third book have add to cart button"+isShow);
	     } catch (org.openqa.selenium.NoSuchElementException e) {
	         System.out.println("The 3rd book does not contain an add to cart button.");
	     }
	}

	@Then("I verify fourth book have Add to Cart button")
	public void i_verify_fourth_book_have_add_to_cart_button() throws InterruptedException {
		homePage.click_on_Book_Btn();
		Thread.sleep(1000);
		booksPage.fourth_book.click();
		Thread.sleep(5000);
		 try {
			 boolean isShow=booksPage.isElementDisplayed(booksPage.Book_AddToCart_Btn);
			 logger.info("check on the book4");
	     } catch (org.openqa.selenium.NoSuchElementException e) {
	         System.out.println("The 4th book does not contain an add to cart button.");
	     }
	}

	@Then("I verify fifth book have Add to Cart button")
	public void i_verify_fifth_book_have_add_to_cart_button() throws InterruptedException {
		homePage.click_on_Book_Btn();
		Thread.sleep(1000);
		booksPage.fifth_book.click();
		Thread.sleep(3000);
		 try {
			 boolean isShow=booksPage.isElementDisplayed(booksPage.Book_AddToCart_Btn);
			 logger.info("check on the book5");
	     } catch (org.openqa.selenium.NoSuchElementException e) {
	         System.out.println("The 5th book does not contain an add to cart button.");
	     }
	}

	@Then("I verify sixth book have Add to Cart button")
	public void i_verify_sixth_book_have_add_to_cart_button() throws InterruptedException {
		homePage.click_on_Book_Btn();
		Thread.sleep(1000);
		booksPage.second_book.click();
		Thread.sleep(3000);
		 try {
			 boolean isShow=booksPage.isElementDisplayed(booksPage.Book_AddToCart_Btn);
			 logger.info("check on the book6");
	     } catch (org.openqa.selenium.NoSuchElementException e) {
	         System.out.println("The 6th book does not contain an add to cart button.");
	     }
	}

	
}
