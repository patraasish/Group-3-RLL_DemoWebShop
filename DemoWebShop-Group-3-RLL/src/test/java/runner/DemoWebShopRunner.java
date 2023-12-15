package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {
				//shaikh
				//"C:\\Users\\HP\\eclipse-workspace-new\\DemoWebShop-Group-3-RLL\\src\\test\\resources\\DemoWebShop_Recently_Viewed_Products.feature",
				//Arpita
				//"C:\\Users\\HP\\eclipse-workspace-new\\DemoWebShop-Group-3-RLL\\src\\test\\resources\\RegisterTest1.feature",
				//Sharath
				//"C:\\Users\\HP\\eclipse-workspace-new\\DemoWebShop-Group-3-RLL\\src\\test\\resources\\DemoWebShopLogin.feature",
				//Diskansh
				//"C:\\Users\\HP\\eclipse-workspace-new\\DemoWebShop-Group-3-RLL\\src\\test\\resources\\search.feature"	,
				//joshnita
				//"C:\\Users\\HP\\eclipse-workspace-new\\DemoWebShop-Group-3-RLL\\src\\test\\resources\\WebDemoShop_AddToCart_2jh.feature",
				//Asish
				//"C:\\Users\\HP\\eclipse-workspace-new\\DemoWebShop-Group-3-RLL\\src\\test\\resources\\DemoWebShop_Wishlist.feature",
				//Ananya
				//"C:\\Users\\HP\\eclipse-workspace-new\\DemoWebShop-Group-3-RLL\\src\\test\\resources\\DemoWebShop_AddToCart.feature",
				//chakrapani
				//"C:\\Users\\HP\\eclipse-workspace-new\\DemoWebShop-Group-3-RLL\\src\\test\\resources\\Community_poll.feature",
				//sindhu
				//"C:\\Users\\HP\\eclipse-workspace-new\\DemoWebShop-Group-3-RLL\\src\\test\\resources\\checkout1.feature"
		},
		glue = {"stepDefintion"},
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				  "html:target/TestreportToday.html",
				  "rerun:target/failed.txt"}, 
		monochrome = true )
public class DemoWebShopRunner extends AbstractTestNGCucumberTests {

}
