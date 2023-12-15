package stepDefintion;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import utilities.XLS_DataProvider;

public class CommunityPollStepDefs {

	
	WebDriver driver;
	SharedSteps sharedSteps;
	LoginPage loginPage;
	HomePage homePage; 
	
	private Object[][] testData;
    static int currentRow = 0;
	
	private static final Logger logger =LogManager.getLogger();
	
	
	public CommunityPollStepDefs (SharedSteps sharedSteps) {
		this.sharedSteps = sharedSteps;
	}
	
	@Given("the user accesses the community poll section")
	public void the_user_accesses_the_community_poll_section() {
		driver=sharedSteps.driver;
	    homePage=new HomePage(driver);
	    driver.get(sharedSteps.web_url);
	    String actual_url=driver.getCurrentUrl();
	    Assert.assertEquals(actual_url, sharedSteps.web_url);
	    homePage.dispalyPoll();
	}

	@When("the user attempts to vote without logging in")
	public void the_user_attempts_to_vote_without_logging_in() {
		homePage.voteBtn();
	}

	@Then("the system should display the message Only registered users can vote")
	public void the_system_should_display_the_message_only_registered_users_can_vote() throws InterruptedException {
		Thread.sleep(3000);
        boolean t= homePage.message();
      
	}

	@Given("the user navigate to url")
	public void the_user_navigate_to_url() {
		driver=sharedSteps.driver;
		 loginPage=new LoginPage(driver);
		driver.get(sharedSteps.web_url);
	}

	@Then("the user click on login")
	public void the_user_click_on_login() throws InterruptedException {
		Thread.sleep(2000);
		loginPage.clickLoginLink();

	}

	@Then("the user enter email {string}")
	public void the_user_enter_email(String email) throws EncryptedDocumentException, IOException {
		testData = XLS_DataProvider.getTestData("Sheet1");
		email = (String) testData[currentRow][0];
		loginPage.enter_email(email);
		logger.info("User enter email");
	}

	@Then("the user enter password {string}")
	public void the_user_enter_password(String password) throws EncryptedDocumentException, IOException {
		testData = XLS_DataProvider.getTestData("Sheet1");
		password = (String) testData[currentRow][1];
		loginPage.enter_password(password);
		logger.info("User enter password");
	}
	
	@Then("the user click on login button")
	public void the_user_click_on_login_button() throws InterruptedException {
		Thread.sleep(2000);
    	loginPage.clickLoginButton();
	}

	@Given("the user accesses the community poll section when loged in")
	public void the_user_accesses_the_community_poll_section_when_loged_in() throws InterruptedException {
		Thread.sleep(2000);
		loginPage.pollDisplay();
	}

	@When("the user casts a vote for any option")
	public void the_user_casts_a_vote_for_any_option() throws InterruptedException {
		Thread.sleep(2000);
		try {
		if(loginPage.vote_btn.isDisplayed()) {
			homePage.voteBtn();	
			}
		}
		catch(org.openqa.selenium.NoSuchElementException e) {
			logger.info("User already polled");
		}
	}

	@Then("the system should display the accurate voting percentage")
	public void the_system_should_display_the_accurate_voting_percentage() throws InterruptedException {
		Thread.sleep(2000);
		loginPage.percentage();
    	
	}

}
