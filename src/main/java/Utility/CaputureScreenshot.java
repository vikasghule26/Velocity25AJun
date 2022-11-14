package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;

public class CaputureScreenshot extends TestBase {
	
	public static void screenshot(String name) throws Exception
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Dell\\eclipse-"
				+ "workspace\\Frame1\\ScreenShots\\photo.jpeg");
	    FileHandler.copy(source, dest);
	}
	
	

}
