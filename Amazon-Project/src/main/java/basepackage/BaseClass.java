package basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeTest;


import actionDriver.Actionclass;



public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	
	
	@BeforeTest(groups = {"Smoke","Sanity","Regression"})
	public void loadconfig() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\tithi\\Desktop\\"
					+ "Software Testing\\Amazon_Project-TDD\\Configuration"
					+ "\\Config.properties");
			prop.load(file);					
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void launchapp() {
		
		String browser = prop.getProperty("Browser");
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		}
		
		else if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/geckodriver.exe");
			driver = new FirefoxDriver ();
		}
		
		else if(browser.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "src/test/resources/Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
	
		driver.manage().window().maximize();
		Actionclass.implicitWait(driver, 10);
		Actionclass.pageLoadTimeOut(driver, 20);
		driver.get(prop.getProperty("URL"));
		driver.navigate().refresh();
		
	}

	public static void snaps(String filename) {
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(file, new File("C:\\Users\\tithi\\Desktop\\Software Testing\\"
				+ "Amazon_Project-TDD\\Screenshots\\Screenshots" +filename+".jpg"));
		}
		catch(IOException e) {e.printStackTrace();}
		
	}
}
