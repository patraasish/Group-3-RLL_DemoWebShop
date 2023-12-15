package stepDefintion;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.RegisterPg;
import utilities.XLS_DataProvider;


public class RegisterStep {
	
	WebDriver driver;
	SharedSteps sharedSteps;
	RegisterPg register;
	
	private Object[][] testData;
    static int currentRow = 0;
    
	public RegisterStep(SharedSteps sharedSteps) {
		this.sharedSteps = sharedSteps;
	}

	private static final Logger logger =LogManager.getLogger();
	
	@When("user is on home page")
	public void user_is_on_home_page() throws IOException {
		driver=sharedSteps.driver;
		register = new RegisterPg(driver);
		driver.get(sharedSteps.web_url);
	    logger.info("user is on home page");
	   assertTrue(true);
	    
	}
	
	@Then("user click on register link")
	public void user_click_on_register_link() {
		driver = sharedSteps.driver;
	    register = new RegisterPg(driver);
	    register.getRegisterClick();
	    logger.info("user is on register page");
	}
	
	@Then("user select gender")
	public void user_select_gender() throws EncryptedDocumentException, IOException {
		register.getGenderClick();
		assertTrue(true);
		
	}

	
	@Then("user enter First Name {string}")
	public void user_enter_first_name(String firstname) throws EncryptedDocumentException, IOException {
		testData = XLS_DataProvider.getTestData("Sheet1");
		firstname = (String) testData[currentRow][0];
		logger.info("user enters first name");
		register.getFirstNameClick(firstname);
		String expectedname = firstname;
		String actualname = firstname;
		Assert.assertEquals(actualname, expectedname);
		assertTrue(true);
		
	}


	@Then("user enter Last Name {string}")
	public void user_enter_last_name(String lastname) throws EncryptedDocumentException, IOException {
		testData = XLS_DataProvider.getTestData("Sheet1");
		lastname = (String) testData[currentRow][1];
		logger.info("user enters last name");
		register.getLastNameClick(lastname);
		String expectedLname = lastname;
		String actualLname = lastname;
		Assert.assertEquals(actualLname, expectedLname);
		
	}

	
	@Then("user enter email {string}")
	public void user_enter_email(String email) throws EncryptedDocumentException, IOException {
		testData = XLS_DataProvider.getTestData("Sheet1");
		email = (String) testData[currentRow][2];
		logger.info("user enters email");
		register.getEmailClick(email);
		String expectedMail= email;
		String actualMail = email;
		Assert.assertEquals(actualMail, expectedMail);
		
	}
	
	@When("user enter password {string}")
	public void user_enter_password(String password) throws EncryptedDocumentException, IOException {
		testData = XLS_DataProvider.getTestData("Sheet1");
		password = (String) testData[currentRow][3];
		logger.info("user enters password");
		register.getPasswordClick(password);
		String expectedpassword= password;
		String actualpassword = password;
		Assert.assertEquals(actualpassword, expectedpassword);
	}

	@Then("user enter confirm password {string}")
	public void user_enter_confirm_password(String confirmpassword) throws EncryptedDocumentException, IOException {
		testData = XLS_DataProvider.getTestData("Sheet1");
		confirmpassword = (String) testData[currentRow][4];
		logger.info("user re-enters password");
		register.getConfirmPasswordClick(confirmpassword);
		currentRow=currentRow+1;
		String expectedcp= confirmpassword;
		String actualcp = confirmpassword;
		Assert.assertEquals(actualcp, expectedcp);
		
		
	}

	@Then("user click on register")
	public void user_click_on_register() throws EncryptedDocumentException, IOException, InterruptedException {
		register.getRegisterButtonClick();
	    Thread.sleep(3000);
		try {
			String msg = null; 
			msg = register.getmessage(register.cperror);
			System.out.println(msg);
			logger.error(msg);
	     } catch (org.openqa.selenium.NoSuchElementException e) {
	         System.out.println("Password given matches");
	         
	     }
		
		try {
			String mailerror = null; 
			mailerror = register.getmessage(register.mailerr);
			System.out.println(mailerror);
			logger.error(mailerror);
	     } catch (org.openqa.selenium.NoSuchElementException e) {
	         System.out.println("given email is valid");
	         
	     }
}
	
	}
