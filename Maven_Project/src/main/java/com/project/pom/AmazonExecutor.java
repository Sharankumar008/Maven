package com.project.pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.Maven_Project.BaseClass;

public class AmazonExecutor extends BaseClass {

	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		String browser = ConfigHelper.getConfigReader().getBrowser();
		driver = webMethod(browser);

		AmazonPomManager pom = new AmazonPomManager(driver);

		String url = ConfigHelper.getConfigReader().getUrl();
		getUrl(url);
		pom.amazonHomePage().getSignIn().click();
		
		WebElement emailOrPhone = pom.amazonSignInpage().getEmailOrPhone();
		String email = ConfigHelper.getConfigReader().getEmail();
		sendKeysInput(emailOrPhone, email);
		pom.amazonSignInpage().getContinueButton().click();
		
		WebElement password = pom.amazonSignInpage().getPassword();
		String pass = ConfigHelper.getConfigReader().getPass();
		sendKeysInput(password, pass);
		pom.amazonSignInpage().getSignInButton().click();

	}

}
