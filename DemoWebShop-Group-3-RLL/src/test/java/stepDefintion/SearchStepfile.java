package stepDefintion;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pagefactory.Searchtestdemo;
import utilities.XLS_DataProvider;


public class SearchStepfile {
	
	SharedSteps sharedSteps;
	Searchtestdemo searchtestdemo; 
	private Object[][] testData;
	static int currentRow = 0;
	WebDriver driver;
	private static final Logger logger =LogManager.getLogger();
	
	public SearchStepfile(SharedSteps sharedSteps) {
		this.sharedSteps = sharedSteps;
	}
	
	
	@Given("User open the URL")
	public void user_open_the_url() {
		driver=sharedSteps.driver;
		searchtestdemo=new Searchtestdemo(driver);
		driver.get(sharedSteps.web_url);
	    String actual_url=driver.getCurrentUrl();
	    Assert.assertEquals(actual_url,sharedSteps.web_url);
	    logger.info("User open the URL");
		
	}

	@Then("clicks on the Search tab")
	public void clicks_on_the_search_tab() throws InterruptedException {
	    
		searchtestdemo.clickonsearch();
		logger.info("clicks on the Search tab");
	}

	@Then("User enters following details to search and click on search button {string}")
	public void user_enters_following_details_to_search_and_click_on_search_button(String Itemtosearch)throws InterruptedException, EncryptedDocumentException, IOException {
		testData = XLS_DataProvider.getTestData("Sheet2");
		Itemtosearch = (String) testData[currentRow][0];
		System.out.println(Itemtosearch);
		System.out.println(currentRow);
		searchtestdemo.writeonsearch(Itemtosearch);
		logger.info("User enters following details to search and click on search button ");
		currentRow = currentRow + 1;
		
	}

	@Then("User clicks on the demowebshop logo")
	public void user_clicks_on_the_demowebshop_logo() throws InterruptedException {
	    
		
		searchtestdemo.Backtohomepage.click();		
		logger.info("User clicks on the demowebshop logo");
	}
}