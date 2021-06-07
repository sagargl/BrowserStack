package com.myTests;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	TestUtil util;
	
	public LoginPageTest()
	{
		super();
	}
	
	
	@BeforeClass
	public void setUP()
	{ 
		
		initialization();
		util=new TestUtil();
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginTest()
	{
		loginpage.login(prop.getProperty("uname"), prop.getProperty("pwd"));
		
	}
	

	@Test(priority = 2)
	public void checkInventoryItemTest() {
		Assert.assertTrue(driver.findElements(By.cssSelector(".inventory_item")).size() == 6);
	}

	@Test(priority = 3)
	public void checkAddToCartButtonTest() {
		Assert.assertTrue(driver.findElements(By.xpath("//button[text()='ADD TO CART']")).size() == 6);
	}


  
	
	@AfterClass()
	public void tearDown()
	{
		driver.quit();
	}
}
