package com.project.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {

	public static WebDriver driver;

	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nav-logo-sprites")
	private WebElement logo;

	public WebElement getLogo() {
		return logo;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getSearchDropDown() {
		return searchDropDown;
	}

	public WebElement getLanguageSelect() {
		return languageSelect;
	}

	public WebElement getSignIn() {
		return signIn;
	}

	public WebElement getOrders() {
		return orders;
	}

	public WebElement getCart() {
		return cart;
	}

	@FindBy(id = "glow-ingress-line2")
	private WebElement location;
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBar;
	@FindBy(id = "searchDropdownBox")
	private WebElement searchDropDown;
	@FindBy(xpath = "//span[@aria-label='India']")
	private WebElement languageSelect;
	@FindBy(xpath = "//span[normalize-space()='Account & Lists']")
	private WebElement signIn;
	@FindBy(id = "nav-orders")
	private WebElement orders;
	@FindBy(id = "nav-cart-count")
	private WebElement cart;
}
