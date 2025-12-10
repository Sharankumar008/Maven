package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseClass;
import pageobjects.HomePage;
import pageobjects.IndexPage;
import pageobjects.SignInPage;

public class SigninTest extends BaseClass {
	HomePage hp;
	SignInPage signin;
	IndexPage index;
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchapp();snaps("SigninTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
	
	@Test(groups = {"Smoke","Sanity"})
	public void signin() throws Throwable {
		hp = new HomePage();
		signin = hp.clickonsignin();
		signin.login(prop.getProperty("Username"));
		index = signin.pw(prop.getProperty("Password"));
	   	Thread.sleep(1500);
		String actualurl = index.getcurrurl();
		String expectedurl = "https://www.amazon.ca/?ref_=nav_ya_signin";
		Assert.assertEquals(actualurl, expectedurl);
		System.out.println("It is same as expected :) ");
	}
	
	
	
}
