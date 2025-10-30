package com.project.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AmazonPomManager {

	public static WebDriver driver;

	public AmazonPomManager(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static AmazonHomePage amazonHomePage() {
		AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
		return amazonHomePage;
	}

	public static AmazonSignInPage amazonSignInpage() {
		AmazonSignInPage amazonSignInPage = new AmazonSignInPage(driver);
		return amazonSignInPage;

	}

}
