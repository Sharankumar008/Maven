package com.dataDrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonDataDriven {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		BaseClass.webMethod("chrome");
		BaseClass.getUrl("https://www.amazon.in/");
		String path=System.getProperty("user.dir") + "\\Resources\\Book.xlsx";
		int rowCount = ExcelUtils.getRowCount(path, "Sheet2");
		
		String email = ExcelUtils.getCellData(path, "Sheet2", rowCount, 0);
		String pass = ExcelUtils.getCellData(path, "Sheet2", rowCount, 1);
		
		driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']")).click();
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(email);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		

	}

}
