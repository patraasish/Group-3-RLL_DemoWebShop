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
import pagefactory.LoginPage;
import utilities.XLS_DataProvider;

public class DemowebshopLogin {
	
	WebDriver driver;
	SharedSteps sharedSteps;
	LoginPage loginPage;
	private Object[][] testData;
    static int currentRow = 0;
    
	
	private static final Logger logger =LogManager.getLogger();
	
	public DemowebshopLogin(SharedSteps s) {
		this.sharedSteps=s;
	}
	
	@Given("I am on Demowebshop home page")
	public void i_am_on_demowebshop_home_page() throws IOException {
	logger.info("I am on Demowebshop home page");
		
		driver=sharedSteps.driver;
		loginPage=new LoginPage(driver); 
	    driver.get(sharedSteps.web_url);
	    String actual_url=driver.getCurrentUrl();
	    Assert.assertEquals(actual_url, sharedSteps.web_url);
	}

	@When("I click on Login")
	public void i_click_on_login() {
		logger.info("I click on Login");
		boolean result=loginPage.isElementDisplayed(loginPage.link_login);
		assertTrue(result);
		loginPage.clickLoginLink();
		
	}

	
	@When("I enter username {string}")
	public void i_enter_username(String email) throws EncryptedDocumentException, IOException {
		logger.info("I enter username");
		boolean result=loginPage.isElementDisplayed(loginPage.Txtbox_Username);
		assertTrue(result);
		testData = XLS_DataProvider.getTestData("Sheet1");
		email = (String) testData[currentRow][0];
		loginPage.enter_email(email);
	}
	@When("I enter password {string}")
	public void i_enter_password(String password) throws EncryptedDocumentException, IOException {
		logger.info("I enter password ");
		boolean result=loginPage.isElementDisplayed(loginPage.Txtbox_Password);
		assertTrue(result);
		testData = XLS_DataProvider.getTestData("Sheet1");
		password = (String) testData[currentRow][1];
		loginPage.enter_password(password);
		
		currentRow=currentRow+1;
	}

	@Then("I click on Login submit button")
	public void i_click_on_login_submit_button() {
		logger.info("I click on Login submit button");
		boolean result=loginPage.isElementDisplayed(loginPage.Btn_login);
		assertTrue(result);
		loginPage.clickLoginsubmitButton();
	}
}
