package com.project.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSignInPage {
	public static WebDriver driver;

	public AmazonSignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ap_email_login")
	private WebElement emailOrPhone;

	public WebElement getEmailOrPhone() {
		return emailOrPhone;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getCreateAccount() {
		return createAccount;
	}

	@FindBy(id = "continue")
	private WebElement continueButton;
	@FindBy(id = "createAccountSubmit")
	private WebElement createAccount;
	@FindBy(id = "ap_password")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}

	@FindBy(id = "signInSubmit")
	private WebElement signInButton;

}
