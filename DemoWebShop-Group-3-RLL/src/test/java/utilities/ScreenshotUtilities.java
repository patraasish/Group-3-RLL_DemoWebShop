package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import stepDefintion.SharedSteps;



public class ScreenshotUtilities{

	public static final String screenshot_path="C:\\Users\\HP\\eclipse-workspace-new\\DemoWebShop-Group-3-RLL\\target\\screenshots_";
	
	public String takeScreenshot() throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)SharedSteps.driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String path=screenshot_path+System.currentTimeMillis()+".png";
		File target=new File(path);
		FileUtils.copyFile(source, target);
		String targetPath=target.getAbsolutePath();
		
		return targetPath;
		
		
		
	}
}