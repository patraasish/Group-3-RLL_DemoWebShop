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
import pagefactory.DigitalDownloadsPage;
import pagefactory.HomePage;
import pagefactory.WishlistPage;

public class WishlistStepDefs {
	
	WebDriver driver;
	SharedSteps sharedSteps;
	DigitalDownloadsPage digitalDownloadsPage;
	HomePage homePage ;
	WishlistPage wishlistPage;
	
	
	private static final Logger logger =LogManager.getLogger();
	
	
	public WishlistStepDefs(SharedSteps sharedSteps) {
		this.sharedSteps = sharedSteps;
	}
	
	@Given("User on the webpage")
	public void user_on_the_webpage() throws IOException {
		
		driver=sharedSteps.driver;
	    homePage=new HomePage(driver);
	    digitalDownloadsPage=new DigitalDownloadsPage(driver);
	    wishlistPage =new WishlistPage(driver);
	    driver.get(sharedSteps.web_url);
	    String actual_url=driver.getCurrentUrl();
	    Assert.assertEquals(actual_url,sharedSteps.web_url);
	    logger.info("User on the webpage");
	    
	}

	@When("User click on digital downloads tab")
	public void user_click_on_digital_downloads_tab() {
		logger.info("Inside User click on digital downloads tab steps");
		boolean result=homePage.isElementDisplayed(homePage.Digital_download_Link);
		assertTrue(result);
		homePage.click_on_Digital_Download();
		logger.info("User click on digital downloads tab");
		
	}
	
	
	@Then("User click on the first product")
	public void user_click_on_the_first_product() {
		
		boolean result=digitalDownloadsPage.isElementDisplayed(digitalDownloadsPage.first_Product);
		assertTrue(result);
		digitalDownloadsPage.click_on_first_product();
		logger.info("User click on the first product");
		
	}


	@Then("User click on first product Add to wishlist button")
	public void user_click_on_first_product_add_to_wishlist_button() throws InterruptedException {
		boolean result=digitalDownloadsPage.isElementDisplayed(digitalDownloadsPage.first_Products_Wishlist_Btn);
		assertTrue(result);
		digitalDownloadsPage.click_on_first_Products_Wishlist_Btn();
		Thread.sleep(3000);
		String ExpectedMessage="The product has been added to your wishlist";
		String ActualMessage=digitalDownloadsPage.getSuccessMessage();
		System.out.println(ActualMessage);
		Assert.assertEquals(ActualMessage,ExpectedMessage);
		logger.info("User click on first product Add to wishlist button");
	}



	@Then("User click on digital download tab for second time")
	public void user_click_on_digital_download_tab_for_second_time() {
	
		boolean result=homePage.isElementDisplayed(homePage.Digital_download_Link);
		assertTrue(result);
		homePage.click_on_Digital_Download();
		logger.info("User click on digital download tab for second time");
		
	}

	@When("User click on the second available product")
	public void user_click_on_the_second_available_product() {
		
		boolean result=digitalDownloadsPage.isElementDisplayed(digitalDownloadsPage.second_Product);
		assertTrue(result);
		digitalDownloadsPage.click_on_second_product();
		logger.info("User click on the second available product");
	}



	@Then("User click on second products Add to wishlist button")
	public void user_click_on_second_products_add_to_wishlist_button() {
		
		boolean result=digitalDownloadsPage.isElementDisplayed(digitalDownloadsPage.second_Products_Wishlist_Btn);
		assertTrue(result);
		digitalDownloadsPage.click_on_second_product_wishlist_Btn();
		logger.info("User click on second products Add to wishlist button");
		}

	@Then("User click on digital download tab for third time")
	public void user_click_on_digital_download_tab_for_third_time() {
	
		boolean result=homePage.isElementDisplayed(homePage.Digital_download_Link);
		assertTrue(result);
		homePage.click_on_Digital_Download();
		logger.info("User click on digital download tab for third time");
	}

	@When("User click on the third available product")
	public void user_click_on_the_third_available_product() {
		
		boolean result=digitalDownloadsPage.isElementDisplayed(digitalDownloadsPage.third_Product);
		assertTrue(result);
		digitalDownloadsPage.click_on_third_product();
		logger.info("User click on the third available product");
	}


	
	@Then("User click on third products Add to wishlist button")
	public void user_click_on_third_products_add_to_wishlist_button() {
		
		boolean result=digitalDownloadsPage.isElementDisplayed(digitalDownloadsPage.third_Products_Wishlist_Btn);
		assertTrue(result);
		digitalDownloadsPage.click_on_third_Products_Wishlist_Btn();
		logger.info("User click on third products Add to wishlist button ");
	}

	@Then("User click on Wishlist link")
	public void user_click_on_wishlist_link() {
	
		boolean result=homePage.isElementDisplayed(homePage.wishlist_Btn);
		assertTrue(result);
	    homePage.click_on_Wishlist_link();
		logger.info("User click on Wishlist link");
	}


	@Then("User click on first products remove check box")
	public void user_click_on_first_products_remove_check_box() {
		
		boolean result= wishlistPage.isElementDisplayed( wishlistPage.remove_first_Product);
		assertTrue(result);
		wishlistPage.click_on_remove_first_product();
		logger.info("User click on first products remove check box");
	}
	@Then("User click on second products remove check box")
	public void user_click_on_second_products_remove_check_box() {
		
		boolean result= wishlistPage.isElementDisplayed( wishlistPage.remove_second_Product);
		assertTrue(result);
		wishlistPage.click_on_remove_second_product();
		logger.info("User click on second products remove check box");
	}

	@Then("User click on third products remove check box")
	public void user_click_on_third_products_remove_check_box() {
		
		boolean result= wishlistPage.isElementDisplayed( wishlistPage.remove_third_Product);
		assertTrue(result);
		wishlistPage.click_on_remove_third_product();
		logger.info("User click on third products remove check box");
	}

	@When("User click on Upadate wishlist button")
	public void user_click_on_upadate_wishlist_button() {
	
		boolean result= wishlistPage.isElementDisplayed( wishlistPage.update_wishlist_Btn);
		assertTrue(result);
		wishlistPage.click_on_update_wishlist_Btn();
		logger.info("User click on Upadate wishlist button");
	}

	@Then("User should able to see empty message")
	public void user_should_able_to_see_empty_message() {
		
		String ExpectedMessage="The wishlist is empty!";
		String ActualMessage =wishlistPage.get_Empty_Message();
		Assert.assertEquals(ActualMessage, ExpectedMessage);
		logger.info("User able to see empty message");
	}

	

}