package com.project.Maven_Project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver webMethod(String webBrowser) {
		if (webBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (webBrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (webBrowser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else if (webBrowser.equalsIgnoreCase("FireFOX")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser");
		}
		return driver;

	}

	public static void getUrl(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public static void maxWindow() {
		driver.manage().window().maximize();

	}

	public static String currentURL() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public static boolean elementDisplayed(WebElement element) {
		waitforElementVisiblity(element);
		boolean displayed = false;
		displayed = element.isDisplayed();
		return displayed;
	}

	public static boolean elementEnabled(WebElement element) {
		waitforElementVisiblity(element);
		boolean enabled = element.isEnabled();
		return enabled;
	}

	public static String currentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public static void windowsHandling(String windowId) {
		Set<String> windowIds = driver.getWindowHandles();
		for (String id : windowIds) {
			{
				if (!(id == windowId))
					driver.switchTo().window(id);
			}
		}
	}

	public static void switchDefault() {
		driver.switchTo().defaultContent();
	}

	public static void scrollToElement(WebElement element) {
		waitforElementVisiblity(element);
		((JavascriptExecutor) driver).executeScript("arguments[0], scrollIntoView();", element);
	}

	public static void scrollUsingCoOrdinates(String width, String height) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(" + width + "," + height + ")");
	}

	public static void scroll(String option) {
		if (option.equalsIgnoreCase("top")) {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		} else if (option.equalsIgnoreCase("bottom")) {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
		}
	}

	public static void dragAndDrop(WebElement sourceElement, WebElement placedElement) {
		Actions ac = new Actions(driver);
		ac.dragAndDrop(sourceElement, placedElement);
	}

	public static void mouseHoverToElement(WebElement element) {
		waitforElementVisiblity(element);
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();

	}

	public static void takeScreenShot(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("images\\" + fileName + ".png");
		FileHandler.copy(src, des);

	}

	public static void waitforElementVisiblity(WebElement element) {
		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(10));
		wb.until(ExpectedConditions.visibilityOf(element));
	}

	public static void sendKeysInput(WebElement element, String value) {
		waitforElementVisiblity(element);
		if (elementDisplayed(element) && elementEnabled(element)) {
			element.sendKeys(value);
		}
	}

	public static String getElement(WebElement element) {
		waitforElementVisiblity(element);
		String text = element.getText();
		return text;

	}

	public static String getAttribute(WebElement element, String a) {
		waitforElementVisiblity(element);
		String attribute = element.getAttribute(a);
		return attribute;
	}

	public static void webElementClick(WebElement element) {
		waitforElementVisiblity(element);
		if (elementDisplayed(element)) {
			element.click();
		}
	}

	public static void simpleAlert(WebElement element) {
		waitforElementVisiblity(element);
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();
		driver.switchTo().defaultContent();
	}

	public static void confirmAlert(WebElement element, String condition) {
		waitforElementVisiblity(element);
		Alert confirmAlert = driver.switchTo().alert();
		if (condition.equalsIgnoreCase("accept")) {
			confirmAlert.accept();
			driver.switchTo().defaultContent();
		} else if (condition.equalsIgnoreCase("dismiss")) {
			confirmAlert.dismiss();
			driver.switchTo().defaultContent();
		}
	}

	public static void promptAlert(WebElement element, String condition, String keys) {
		waitforElementVisiblity(element);
		Alert promptAlert = driver.switchTo().alert();
		if (condition.equalsIgnoreCase("accept")) {
			promptAlert.sendKeys(keys);
			promptAlert.accept();
			driver.switchTo().defaultContent();
		} else if (condition.equalsIgnoreCase("dismiss")) {
			promptAlert.dismiss();
			driver.switchTo().defaultContent();
		}

	}

	public static void clickAction(WebElement element, String option) {
		Actions click = new Actions(driver);
		waitforElementVisiblity(element);
		if (option.equalsIgnoreCase("double click")) {
			click.doubleClick(element).build().perform();
		} else if (option.equalsIgnoreCase("right click")) {
			click.contextClick(element).build().perform();
		}
	}

	public static void switchToFrameUsingElement(WebElement element) {
		waitforElementVisiblity(element);
		driver.switchTo().frame(element);
	}

	public static void switchToFrameUsingIndex(int index) {
		driver.switchTo().frame(index);
	}

	public static void switchToDefault() {
		driver.switchTo().defaultContent();
	}

	public static void keyboard(String option) throws AWTException {
		Robot r = new Robot();
		if (option.equalsIgnoreCase("enter")) {
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		} else if (option.equalsIgnoreCase("a")) {
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_A);
		}

	}

}
