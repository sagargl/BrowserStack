package com.myTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserStackTest extends BaseTest {
	
	public void doLogin()
	{
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}
	
	@Test(priority = 1)
	public void checkInventoryItemTest() {
		doLogin();
		Assert.assertTrue(driver.findElements(By.cssSelector(".inventory_item")).size() == 6);
	}

	@Test(priority = 2)
	public void checkAddToCartButtonTest() {
		doLogin();
		Assert.assertTrue(driver.findElements(By.xpath("//button[text()='ADD TO CART']")).size() == 6);
	}

	

}
