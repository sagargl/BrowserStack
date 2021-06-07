package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;


public class LoginPage extends TestBase{
	
	//PageFactory-OR:
		@FindBy(id="user-name")
		WebElement username;
		
		@FindBy(id="password")
		WebElement password;
		
		@FindBy(id="login-button")
		WebElement loginbutton;;
		
		
		
		//Initiliaze the page objects
		public LoginPage()
		{
			//PageFactory.initElements(driver, LoginPage.class);
			PageFactory.initElements(driver, this);
		}
		
	    //Action class
		
		
		public void login(String un, String pw)
		{
			username.sendKeys(un);
			password.sendKeys(pw);
			loginbutton.click();
		}
		

}
